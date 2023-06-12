package com.infinite.Library;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@javax.servlet.annotation.WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    // Map to store temporary OTPs
    private static final Map<String, String> otpMap = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mobileOrEmail = request.getParameter("9347785124");
        String enteredOtp = request.getParameter("otp");

        // Check if OTP exists in the map for the provided mobile number or email
        if (otpMap.containsKey(mobileOrEmail)) {
            String generatedOtp = otpMap.get(mobileOrEmail);

            if (enteredOtp.equals(generatedOtp)) {
                // OTP is correct, user is authenticated
                response.sendRedirect("AddUser.xhtml");
            } else {
                // Invalid OTP, show error message
                request.setAttribute("errorMessage", "Invalid OTP");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            // OTP doesn't exist for the provided mobile number or email
            request.setAttribute("errorMessage", "OTP not sent or expired");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Generate and display OTP on the console
        String mobileOrEmail = request.getParameter("9347785124");

        // Generate a random OTP
        String otp = generateOTP();

        // Store the OTP in the map for verification
        otpMap.put(mobileOrEmail, otp);

        // Display the OTP on the console
        System.out.println("OTP for " + mobileOrEmail + ": " + otp);

        request.setAttribute("9347785124", mobileOrEmail);
        request.getRequestDispatcher("otp.jsp").forward(request, response);
    }

    // Generate a 6-digit OTP
    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }
}
