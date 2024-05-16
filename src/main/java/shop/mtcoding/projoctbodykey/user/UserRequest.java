package shop.mtcoding.projoctbodykey.user;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.sql.Timestamp;

public class UserRequest {

    @Data
    public static class UpdateDTO {

        @NotEmpty(message = "이름은 공백일 수 없어요.")
        @Size(min = 2, max = 10, message = "이름은 2 ~ 10자 사이로 작성하셔야 해요.")
        private String name;

        @NotEmpty(message = "비밀번호는 공백일 수 없어요.")
        @Size(min = 4, max = 20, message = "비밀번호는 4 ~ 20자 사이로 작성하셔야 해요.")
        private String password;

        @NotEmpty(message = "휴대폰 번호는 공백일 수 없어요.")
        @Pattern(regexp = "^01([016789])-\\d{4}-\\d{4}$", message = "010-0000-0000 형식으로 작성해주세요")
        private String phone;

        @NotNull(message = "체중은 공백일 수 없어요.")
        @Min(value = 30, message = "체중의 최솟값은 30 이에요.")
        @Max(value = 300, message = "체중의 최대값은 300 이에요.")
        private Double height;
    }

    @Data
    public static class ImgUpdateDTO {

        @NotEmpty(message = "이미지 파일을 넣어주세요.")
        private String userImg;
    }

    @Data
    public static class JoinDTO {

        @NotEmpty(message = "이름은 공백일 수 없어요.")
        @Size(min = 2, max = 10, message = "이름은 2 ~ 10자 사이로 작성하셔야 해요.")
        private String name;

        @NotEmpty(message = "ID는 공백일 수 없어요.")
        @Pattern(regexp = "^[a-zA-Z0-9]{2,20}$", message = "영문/숫자 2~20자 이내로 작성해주세요")
        private String username;

        @NotEmpty(message = "비밀번호는 공백일 수 없어요.")
        @Size(min = 4, max = 20, message = "비밀번호는 4 ~ 20자 사이로 작성하셔야 해요.")
        private String password;


        private Timestamp birth;
        private Character gender;
        private String phone;
        private double height;

        public User toEntity(String encPassword) {
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
    }

    @Data
    public static class LoginDTO {
        private String username;
        private String password;

        public LoginDTO(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    @Data
    public static class GoalFatUpdateDTO {
        private Double goalFat;
    }

    @Data
    public static class GoalMuscleUpdateDTO {
        private Double goalMuscle;
    }

    @Data
    public static class GoalWeightUpdateDTO {
        private Double goalWeight;
    }

    @Data
    public static class UsernameCheckDTO {
        private String username;
    }
}
