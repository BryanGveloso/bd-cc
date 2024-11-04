package com.example.loginauthapi.Util;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendSetPasswordEmail(String email) throws MessagingException {
    MimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
    mimeMessageHelper.setTo(email);
    mimeMessageHelper.setSubject("Set Password");
    mimeMessageHelper.setText("""
            <div>
            <a href="http://localhost:8080/set-password?email=%s" target="_blank"> click link to set a password</a>
            </div>
            """.formatted(email, otp), true);

    javaMailSender.send(mimeMessage);
    }


}
