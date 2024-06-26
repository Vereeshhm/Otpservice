package com.example.Otpservice.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/application.properties")
public class PropertiesConfig {

	@Value("${username}")
	private String username;

	@Value("${apikey}")
	private String apikey;

	@Value("${signature}")
	private String signature;

	@Value("${msgtype}")
	private String msgtype;

	@Value("${entityid}")
	private String entityid;

	@Value("${templateid}")
	private String templateid;

	@Value("${OTP.baseURL}")
	private String OtpBaseUrl;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getEntityid() {
		return entityid;
	}

	public void setEntityid(String entityid) {
		this.entityid = entityid;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getOtpBaseUrl() {
		return OtpBaseUrl;
	}

	public void setOtpBaseUrl(String otpBaseUrl) {
		OtpBaseUrl = otpBaseUrl;
	}
}
