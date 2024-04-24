package com.example.Otpservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.Otpservice.ServiceImpl.OtpServiceImpl;


public class Config {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

	@Bean
	public OtpServiceImpl smsServiceImpl() {
		return new OtpServiceImpl();
	}
}
