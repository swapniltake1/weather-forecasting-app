package com.swapnil.weather.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class OtpService {

	 // Generate a 6-digit random OTP
    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
    
}
