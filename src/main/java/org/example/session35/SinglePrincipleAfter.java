package org.example.session35;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SinglePrincipleAfter {
}

class UserValidation {
    public void validation(String username, String email, String password) {
        if (username == null || username.length() < 2) {
            throw new IllegalArgumentException("username validation failed");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("email validation failed");
        }
        if (password.length() < 6) {
            throw new IllegalArgumentException("password validation failed");
        }
    }
}

class UserRepository {
    public void saveUser(String username, String email, String password) {
        try (Connection connection = DriverManager.getConnection("con1")) {
            String sql = " insert into Users (usarname, email, password) values (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

class UserEmailService {
    public void sendEmail(String username, String email) {
        try {
            //email configuration
            //email send
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class UserRegistrationService{
    private UserValidation userValidation;
    private UserRepository userRepository;
    private UserEmailService userEmailService;

    public UserRegistrationService(UserValidation userValidation, UserRepository userRepository, UserEmailService userEmailService) {
        this.userValidation = userValidation;
        this.userRepository = userRepository;
        this.userEmailService = userEmailService;
    }

    public void regitrationUser(String username, String email, String password){
        userValidation.validation(username,email,password);
        userRepository.saveUser(username,email,password);
        userEmailService.sendEmail(username,email);
    }
}