package com.example.loginauthapi.Services;

import com.example.loginauthapi.Util.EmailUtil;
import com.example.loginauthapi.model.User;
import com.example.loginauthapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    private final UserRepository userRepository;
    private final EmailUtil emailUtil;

    public UserServices(UserRepository userRepository, EmailUtil emailUtil) {
        this.userRepository = userRepository;
        this.emailUtil = emailUtil;
    }

    public String  forgotPassword(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException("User not found with this email: " + email));
        try{
            emailUtil.sendSetPasswordEmail(email);
        } catch (MessagingException e){
            throw new RuntimeException("Unable to send set password email please try again");
        }
    return "Please check your email to set new password to your account";
    }

    public String setPassword(String email, String newPassword){
        User user = userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new RuntimeException("User not found with this email: " + email));
        user.setSenha(newPassword);
        userRepository.save(user);
        return "New password set successfully login with new password"
    }
}
