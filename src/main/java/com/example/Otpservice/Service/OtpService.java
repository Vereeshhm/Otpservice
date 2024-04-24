package com.example.Otpservice.Service;

import com.example.Otpservice.Entity.Otpdto;
import com.example.Otpservice.ServiceResponse.Smsresponse;

public interface OtpService {

	public Smsresponse getOtpSms(Otpdto otpdto);

}
