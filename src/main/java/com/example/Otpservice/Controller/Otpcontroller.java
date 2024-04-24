package com.example.Otpservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Otpservice.Entity.Otpdto;
import com.example.Otpservice.Service.OtpService;
import com.example.Otpservice.ServiceResponse.Smsresponse;

@RestController
public class Otpcontroller {

	
	
	@Autowired
	OtpService otpService;
	
	
	@PostMapping("api/otp")
	public ResponseEntity<Smsresponse> OtpSms(@RequestBody Otpdto  otpdto)
	{
		Smsresponse response=otpService.getOtpSms(otpdto);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
	
	
}
