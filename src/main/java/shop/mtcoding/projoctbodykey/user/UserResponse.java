package shop.mtcoding.projoctbodykey.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
        private String birth;
        private Character gender;
        private double height;

        public JoinDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.username = user.getUsername();
            this.birth = MyDateUtil.timestampFormat(user.getBirth());
            this.gender = user.getGender();
            this.height = user.getHeight();
        }
    }

    record LoginDTO(@JsonIgnore String accessToken, Integer id, String username) {
        LoginDTO(String accessToken, User user) {
            this(accessToken, user.getId(), user.getUsername());
        }
    }
}