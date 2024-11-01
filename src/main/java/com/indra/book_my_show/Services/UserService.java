package com.indra.book_my_show.Services;

import com.indra.book_my_show.Models.UserEntity;
import com.indra.book_my_show.Repositories.UserRepository;
import com.indra.book_my_show.Request.UserEntryDto;
import com.indra.book_my_show.convertors.UserConvertor;
//import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
//    private final Dotenv dotenv = Dotenv.load();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    public String addUser(UserEntryDto userEntryDto) {
        try {
            UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);
            userEntity = userRepository.save(userEntity);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Welcome to Book Your Show Application");
            message.setFrom("email.integration101@gmail.com");
            message.setTo(userEntity.getEmail());

            String body = "Hi " + userEntity.getName() + "!\n" +
                    "Welcome to Book Your Show Application! Use coupon START100 for an instant discount!";
            message.setText(body);

            mailSender.send(message);
            return "User added successfully to the DB with userId: " + userEntity.getUserId();

        } catch (MailException mailEx) {
            logger.error("Error in email sending: ", mailEx);
            return "User couldn't be added due to an email error.";
        } catch (Exception e) {
            logger.error("Unexpected error while adding user: ", e);
            return "User couldn't be added.";
        }

    }
}
