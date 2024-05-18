package shop.mtcoding.projoctbodykey.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.Parent;
import org.springframework.format.annotation.DateTimeFormat;

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

        @NotNull(message = "키를 입력하여 주세요.")
        @Min(value = 100, message = "키는 100이상으로 작성하여 주세요.")
        @Max(value = 250, message = "키는 250이하로 작성하여 주세요.")
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
        @Pattern(regexp = "^[a-zA-Z0-9]{2,14}$", message = "영문/숫자 2~14자 이내로 작성해주세요")
        private String username;

        @NotEmpty(message = "비밀번호는 공백일 수 없어요.")
        @Size(min = 4, max = 20, message = "비밀번호는 4 ~ 20자 사이로 작성하셔야 해요.")
        private String password;

        private Timestamp birth;

        @NotNull(message = "성별을 작성하여 주세요")
        @Pattern(regexp = "[MF]", message = "성별은 'M' 또는 'F' 로 작성하여 주세요")
        private String gender;

        @NotEmpty(message = "휴대폰 번호는 공백일 수 없어요.")
        @Pattern(regexp = "^01([016789])-\\d{4}-\\d{4}$", message = "010-0000-0000 형식으로 작성해주세요")
        private String phone;

        @NotNull(message = "키를 입력하여 주세요.")
        @Min(value = 100, message = "키는 100이상으로 작성하여 주세요.")
        @Max(value = 250, message = "키는 250이하로 작성하여 주세요.")
        private Double height;

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

        @NotEmpty(message = "ID는 공백일 수 없어요.")
        @Pattern(regexp = "^[a-zA-Z0-9]{2,14}$", message = "영문/숫자 2~14자 이내로 작성해주세요")
        private String username;

        @NotEmpty(message = "ID는 공백일 수 없어요.")
        @Pattern(regexp = "^[a-zA-Z0-9]{2,14}$", message = "영문/숫자 2~14자 이내로 작성해주세요")
        private String password;

        public LoginDTO(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    @Data
    public static class GoalFatUpdateDTO {
        @NotNull(message = "목표치값을 입력해주세요.")
        @Min(value = 0, message = "0 이상의 값을 입력하여 주세요.")
        @Max(value = 100, message = "100 이하의 값을 입력하여 주세요.")
        private Double goalFat;
    }

    @Data
    public static class GoalMuscleUpdateDTO {

        @NotNull(message = "목표치값을 입력해주세요.")
        @Min(value = 0, message = "0 이상의 값을 입력하여 주세요.")
        @Max(value = 100, message = "100 이하의 값을 입력하여 주세요.")
        private Double goalMuscle;
    }

    @Data
    public static class GoalWeightUpdateDTO {


        @NotNull(message = "목표치값을 입력해주세요.")
        @Min(value = 0, message = "0 이상의 값을 입력하여 주세요.")
        @Max(value = 200, message = "200 이하의 값을 입력하여 주세요.")
        private Double goalWeight;
    }

    @Data
    public static class UsernameCheckDTO {
        private String username;
    }
}
