package com.swapnil.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.swapnil.weather.res.WeatherResponse;
import com.swapnil.weather.service.OtpService;
import com.swapnil.weather.service.WeatherService;

@Controller
@RequestMapping("/ui")
public class UiController {

	private String generatedOTP;
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private OtpService otpService;
	
	@GetMapping("/")
    public String showIndex() {
        return "index";
    }
	
	@PostMapping("/login")
    public String login(@RequestParam String name, @RequestParam String phone, Model model) {
        // Your logic to validate name and phone
        // Generate OTP and store it in generatedOTP
		generatedOTP = otpService.generateOTP();
       

        // For demonstration purposes, let's print the OTP in the console
        System.out.println("Generated OTP: " + generatedOTP);

        // Pass the generatedOTP to the next view
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        return "verifyOTP";
    }
	
	@PostMapping("/verifyOTP")
	public String verifyOTP(@RequestParam String enteredOTP, Model model, RedirectAttributes redirectAttributes) {
	    if (generatedOTP.equals(enteredOTP)) {
	        // Here, if the OTP is verified successfully, you can redirect to the weather page.
	        redirectAttributes.addFlashAttribute("message", "OTP verified. Login successful.");
	        return "redirect:/ui/weather";
	    } else {
	        model.addAttribute("error", "Invalid OTP. Please try again.");
	        return "verifyOTP";
	    }
	}

	
	@GetMapping("/weather")
    public String weather() {
        return "weather";
    }
	
	@GetMapping("/your-location")
	public String getWeather(Model model, @RequestParam double lat, @RequestParam double lon) {
	    WeatherResponse weatherResponse = weatherService.getCurrentWeather(lat, lon);

	    if (weatherResponse != null) {
	        model.addAttribute("weatherResponse", weatherResponse);
	        return "weatherDetails"; // Replace with the name of your Thymeleaf template file
	    } else {
	        // Handle the case where the weather response is null
	        return "error-template"; // Replace with the name of your error template file
	    }
	}

	
    }