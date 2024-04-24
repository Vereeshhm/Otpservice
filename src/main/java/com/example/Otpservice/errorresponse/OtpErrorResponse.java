package com.example.Otpservice.errorresponse;

import com.example.Otpservice.ServiceResponse.Smsresponse;


public class OtpErrorResponse {

	public static Smsresponse returnInternalServerErrorResponse(Exception e) {
		Smsresponse response = new Smsresponse();
		response.setStatus("FAILURE");
		response.setCode("Internal Server Error Response.!!!");
		response.setDescription(e.getMessage());
		return response;
	}
}
