package shop.mtcoding.projoctbodykey.user;

import lombok.Builder;
import lombok.Data;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;

import java.sql.Timestamp;

public class UserResponse {

    @Data
    public static class JoinDTO {
        private Integer id;
        private String name;
        private String username;
        private String password;
        private String birth;
        private Character gender;
        private double height;

        public JoinDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.username = user.getUsername();
            this.password = user.getPassword();
            this.birth = MyDateUtil.timestampFormat(user.getBirth());
            this.gender = user.getGender();
            this.height = user.getHeight();
        }
    }
}