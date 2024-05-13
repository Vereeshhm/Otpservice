package com.example.Otpservice.ServiceResponse;



import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "otpservicetable")
public class Smsresponse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;

	@Column(name = "status")
	private String status;

	@Column(name = "code")
	private String code;

	@Column(name = "description")

	private String description;
	
	@Column(name="dest")
	private String dest;
	
	@Column(name="otp")
	private int otp;
	
	@Column(name="formattedDate")
	private LocalDateTime formattedDate;
	
	

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



	public LocalDateTime getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(LocalDateTime specificDateTime) {
		this.formattedDate = specificDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String generateFormattedDate() {
		long timestamp=System.currentTimeMillis();
		Date date=new Date(timestamp);
		SimpleDateFormat sdf=new SimpleDateFormat();
		sdf.applyPattern("dd:MM:yyyy''HH:mm:ss");
		return sdf.format(date);
}
}