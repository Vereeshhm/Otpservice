package com.example.Otpservice.ServiceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Otpservice.Entity.Otpdto;
import com.example.Otpservice.Repository.otprepository;
import com.example.Otpservice.Service.OtpService;
import com.example.Otpservice.ServiceResponse.Smsresponse;
import com.example.Otpservice.Utils.PropertiesConfig;
import com.example.Otpservice.errorresponse.OtpErrorResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OtpServiceImpl implements OtpService {

	@Autowired
	otprepository otprepository;

	@Autowired
	PropertiesConfig propertiesConfig;

	@Override
	public Smsresponse getOtpSms(Otpdto otpdto) {

		Smsresponse resSmsresponse = new Smsresponse();
		long startTime = System.currentTimeMillis();
		
		try {
			String baseURL = propertiesConfig.getOtpBaseUrl();

			String username = "SwatApi";
			String dest = otpdto.getDest();
			String apikey = propertiesConfig.getApikey();
			String signature = propertiesConfig.getSignature();
			String msgtype = propertiesConfig.getMsgtype();
			String entityid = propertiesConfig.getEntityid();
			String templateid = "1107170781932088080";
			int smsotp = otpdto.getOtp();
			String msgtxt = "Greetings%20from%20Saswat%20Finance%2C%20your%20otp%20is%20" + smsotp
					+ "%20for%20the%20verification.%20-%20Saswat%20Finance.%20-SASWAT%20Financial%20Services%20Pvt%20LTD";

			// Build the full URL
			String fullURL = String.format(
					"%s?username=%s&dest=%s&apikey=%s&signature=%s&msgtype=%s&msgtxt=%s&entityid=%s&templateid=%s",
					baseURL, username, dest, apikey, signature, msgtype, msgtxt, entityid, templateid);

			URL url = new URL(fullURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Get the response
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			String json = response.toString();

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(json);
			String code = jsonNode.get(0).get("code").asText();
			String desc = jsonNode.get(0).get("desc").asText();
		

			
			if (code.equalsIgnoreCase("6001")) {
				resSmsresponse.setStatus("SUCCESS");
			} else {
				resSmsresponse.setStatus("FAILURE");
			}
			resSmsresponse.setCode(code);
			resSmsresponse.setDescription(desc);
			resSmsresponse.setDest(dest);
			resSmsresponse.setOtp(smsotp);
			//LocalDate date = LocalDate.now();
			LocalDateTime dateTime = LocalDateTime.now();
			
			resSmsresponse.setFormattedDate(dateTime);
			
			otprepository.save(resSmsresponse);
			return resSmsresponse;

		} catch (Exception e) {
			resSmsresponse = OtpErrorResponse.returnInternalServerErrorResponse(e);
		}
		return null;
	}

}
