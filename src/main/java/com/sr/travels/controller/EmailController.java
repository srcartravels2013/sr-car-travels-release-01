package com.sr.travels.controller;

import com.sr.travels.models.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/send")
    public String sendEmail(EmailRequest emailRequest) {
        try {
            // Create a MimeMessage
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Set the recipient's email address
            helper.setTo("srcartravels2013gmailcom@mailbox.cratiocrm.com");

            // Set the email subject
            helper.setSubject("New Lead from \" srcartravels.com \"");

            // Set the email content
            helper.setText("Hi ,\n" +
                    "\n" +
                    "Please find the below form.\n" +
                    "\n" +
                    "Name: Customer\n" +
                    "\n" +
                    "Phone: " + emailRequest.getMobNumber() +"\n" +
                    "\n" +
                    "Mail: " + emailRequest.getEmail() +"\n" +
                    "\n" +
                    " \n" +
                    "\n" +
                    "Regards,\n" +
                    "\n" +
                    "SR Car Travels.");

            // Set the CC recipient's email address
            helper.setCc("srdrivingschool7857@gmail.com");

            // Send the email
            emailSender.send(message);

            return "Email sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending email: " + e.getMessage();
        }
    }
}
