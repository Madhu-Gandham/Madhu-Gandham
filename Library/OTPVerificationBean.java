package com.infinite.Library;

import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.inject.Named;

@ManagedBean(name = "otpVerificationBean", eager = true)
@Named("otpVerificationBean")
public class OTPVerificationBean {

	 private String phoneNumber;
	    private int generatedOTP;
		private String userEnteredOTP;


    private static final String ACCOUNT_SID = "AC9495b96af09e482ca0d7cd1e73588c64";
    private static final String AUTH_TOKEN = "568950460532b54b127e9030629d5de4";
    private static final String TWILIO_PHONE_NUMBER = "+12542774809";

    public void sendOTP() {
        // Generate random OTP
        generatedOTP = generatedOTP();

        // Store the generated OTP in a session attribute
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.setAttribute("generatedOTP", generatedOTP);

        // Send the OTP via SMS using Twilio 
        sendSMS(phoneNumber, "Your OTP is: " + generatedOTP);
    }
    public void validateOTP() {
        // Simulate OTP validation
        // Compare the user-entered OTP with the one stored in the session attribute

        FacesContext context = FacesContext.getCurrentInstance();

        // Retrieve the stored generated OTP from the session attribute
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        int storedOTP = (int) session.getAttribute("generatedOTP");

        System.out.println("Generated OTP: " + storedOTP);
        System.out.println("User Entered OTP: " + userEnteredOTP);

        int enteredOTP;
        try {
            enteredOTP = Integer.parseInt(userEnteredOTP);
        } catch (NumberFormatException e) {
            // Handle if the user-entered OTP is not a valid integer
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid OTP", null);
            context.addMessage(null, message);
            return;
        }

        if (enteredOTP == storedOTP) {
            // Redirect to the menu page if OTP is valid
            redirectToMenuPage();
        } else {
            // Display an error message if OTP is invalid
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid OTP", null);
            context.addMessage(null, message);
        }
    }

    private int generatedOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        System.out.println("Generated OTP: " + otp);
        return otp;
    }


    private void sendSMS(String phoneNumber, String message) {
        // Send an SMS using Twilio
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message sms = Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(TWILIO_PHONE_NUMBER), message).create();
        System.out.println("SMS SID: " + sms.getSid());
    }

    private void redirectToMenuPage() {
        // Redirect to the menu page
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "adminpanel.xhtml");
    }

    // Getters and Setters for phoneNumber, generatedOTP, and userEnteredOTP
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGeneratedOTP() {
        return generatedOTP;
    }

    public void setGeneratedOTP(int generatedOTP) {
        this.generatedOTP = generatedOTP;
    }
    public String getUserEnteredOTP() {
		return userEnteredOTP;
	}

	public void setUserEnteredOTP(String userEnteredOTP) {
		this.userEnteredOTP = userEnteredOTP;
	}


  
}
