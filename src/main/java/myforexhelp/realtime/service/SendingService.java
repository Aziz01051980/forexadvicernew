package myforexhelp.realtime.service;

import myforexhelp.realtime.domain.NameAndEmail;
import myforexhelp.realtime.repository.NameAndEmailRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendingService {

    private JavaMailSender mailSender;

    private NameAndEmailRepository nameAndEmailRepository;

    public SendingService(NameAndEmailRepository nameAndEmailRepository, JavaMailSender mailSender) {
        this.nameAndEmailRepository = nameAndEmailRepository;
        this.mailSender = mailSender;
    }

    public String sendMailToRecipient(String subject, String textOfTheMail) {



        List<String> mails = nameAndEmailRepository.findAllMails();
        for (String mail : mails) {
            try {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setTo(mail);
                mailMessage.setSubject(subject);
                mailMessage.setText(textOfTheMail);
                mailSender.send(mailMessage);
            } catch (Exception e) {
                System.out.println("An error occur");
            }
        }
        return "Mail sent";
    }

    public void gettingMailFromClient(String mail, String subject, String textOfTheMail) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo("olofs80@gmail.com");
            mailMessage.setSubject(subject);
            mailMessage.setText(mail + textOfTheMail);
            mailSender.send(mailMessage);
        } catch (Exception e) {
            System.out.println("An error occur");
        }
    }
}
