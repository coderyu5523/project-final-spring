package shop.mtcoding.projoctbodykey.user;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Timestamp;

public class UserRequest {

    @Data
    public static class JoinDTO {
        private String name;
        private String username;
        private String password;
        private Timestamp birth;
        private Character gender;
        private String phone;
        private double height;

        public User toEntity (String encPassword) {
            return User.builder()
                    .name(name)
                    .username(username)
                    .password(encPassword)
                    .birth(birth)
                    .gender(gender)
                    .phone(phone)
                    .height(height)
                    .build();
        }

        public User toEntity () {
            return User.builder()
                    .name(name)
                    .username(username)
                    .password(password)
                    .birth(birth)
                    .gender(gender)
                    .phone(phone)
                    .height(height)
                    .build();
        }
    }

    @Data
    public static class LoginDTO{
        private String username;
        private String password;

        public LoginDTO(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
