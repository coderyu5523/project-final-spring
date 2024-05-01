package shop.mtcoding.projoctbodykey.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;
import shop.mtcoding.projoctbodykey.bodydata.Bodydata;
import shop.mtcoding.projoctbodykey.challenge.ChallengeResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

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

    @Data
    public static class MyPageDTO {
        private Integer id;
        private String userImg;
        private String name;
        private Double fat;
        private Double muscle;
        private Double weight;
        private List<ConqueredChallengeDTO> conqueredChallenge;

        public MyPageDTO(User user, Bodydata bodydata, List<Object[]> conqueredChallenge) {
            this.id = user.getId();
            this.userImg = user.getUserImg();
            this.name = user.getName();
            this.fat = bodydata.getFat();
            this.muscle = bodydata.getMuscle();
            this.weight = bodydata.getWeight();
            this.conqueredChallenge = conqueredChallenge.stream().map(partChallenge -> new ConqueredChallengeDTO(partChallenge, (String) partChallenge[4])).toList();
        }

        @Data
        public static class ConqueredChallengeDTO {
            private Integer id;
            private String challengeName; // 챌린지명
            private String distance; // 거리
            private Boolean status;
            private String badgeImg;
            public ConqueredChallengeDTO(Object[] conqueredChallenge, String badgeImg) {
                this.id = (Integer) conqueredChallenge[0];
                this.challengeName = (String) conqueredChallenge[1];
                this.distance = (String) conqueredChallenge[2];
                this.status = (Boolean) conqueredChallenge[3];
                try {
                    this.badgeImg = ImageUtil.encode(badgeImg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Data
    public static class UpdateFormDTO {
        private Integer id;
        private String name;
        private String phone;
        private Double height;
        private String userImg;

        public UpdateFormDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.height = user.getHeight();
            try {
                this.userImg = ImageUtil.encode(user.getUserImg());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer id;
        private String name;
        private String phone;
        private Double height;
        private String userImg;

        public UpdateDTO(User user, String userImg) {
            this.id = user.getId();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.height = user.getHeight();
            this.userImg = userImg;
        }
    }
}