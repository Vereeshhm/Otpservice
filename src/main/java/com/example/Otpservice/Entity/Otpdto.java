package com.example.Otpservice.Entity;


import lombok.Data;

@Data
public class Otpdto {

	
	private String dest;
	private int otp;

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Otpdto [dest=" + dest + ", otp=" + otp + "]";
	}

	
}
