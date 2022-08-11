package com.example.springDiabetesCheck.api;

import com.example.springDiabetesCheck.domain.Email;
import com.example.springDiabetesCheck.service.SendEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiemail")
@RequiredArgsConstructor
public class SendEmail {
    private final SendEmailService sendEmailService;

    @PostMapping("/send")
    public void sendEmail(@RequestBody Email email){
        sendEmailService.send(email);
    }

    /*@PostMapping("/sendWithAttachment")
    public void sendWithAttachment(@RequestBody Email email, String file) throws MessagingException {
        sendEmailService.sendWithAttachment(email, file);
    }*/
}
