package com.example.Otpservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Otpservice.ServiceResponse.Smsresponse;

@Repository
public interface otprepository extends JpaRepository<Smsresponse, Integer> {

}
