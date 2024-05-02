package shop.mtcoding.projoctbodykey.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;
import shop.mtcoding.projoctbodykey.bodydata.Bodydata;

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


    @Data
    public static class MainPageDTO {
        private Integer id;
        private String name;
        private Double goalFat; // 사용자의 목표 지방량
        private Double goalMuscle; // 사용자의 목표 근육량

        // 가장 최근 지방량, 근육량, 체중
        private Double fat;
        private Double muscle;
        private Double weight;
        private List<BodyDataDTO> bodyData;

        public MainPageDTO(User user, Bodydata bodyData, List<Bodydata> bodyDataList) {
            this.id = user.getId();
            this.name = user.getName();
            this.goalFat = user.getGoalFat();
            this.goalMuscle = user.getGoalMuscle();
            this.fat = bodyData.getFat();
            this.muscle = bodyData.getMuscle();
            this.weight = bodyData.getWeight();
            this.bodyData = bodyDataList.stream().map(BodyDataDTO::new).toList();
        }

        @Data
        public static class BodyDataDTO {
            private Integer id;
            private Double fat;
            private Double muscle;
            private Double weight;
            private Timestamp date;

            public BodyDataDTO(Bodydata bodyData) {
                this.id = bodyData.getId();
                this.fat = bodyData.getFat();
                this.muscle = bodyData.getMuscle();
                this.weight = bodyData.getWeight();
                this.date = bodyData.getCreatedAt();
            }
        }
    }

    @Data
    public static class MyChangeFatDTO {
        private Integer id;
        private Double golFat;
        private List<fatDataListDTO> fatDataList;

        public MyChangeFatDTO(User user, List<Bodydata> fatDataList) {
            this.id = user.getId();
            this.golFat = user.getGoalFat();
            this.fatDataList = fatDataList.stream().map(fatDataListDTO::new).toList();
        }

        @Data
        public static class fatDataListDTO {
            private Integer id;
            private Double fat;
            private Timestamp date;

            public fatDataListDTO(Bodydata fatDataList) {
                this.id = fatDataList.getId();
                this.fat = fatDataList.getFat();
                this.date = fatDataList.getCreatedAt();
            }
        }
    }

    @Data
    public static class MyChangeMuscleDTO {
        private Integer id;
        private Double golMuscle;
        private List<MuscleDataListDTO> muscleDataList;

        public MyChangeMuscleDTO(User user, List<Bodydata> muscleDataList) {
            this.id = user.getId();
            this.golMuscle = user.getGoalMuscle();
            this.muscleDataList = muscleDataList.stream().map(MuscleDataListDTO::new).toList();
        }

        @Data
        public static class MuscleDataListDTO {
            private Integer id;
            private Double muscle;
            private Timestamp date;

            public MuscleDataListDTO(Bodydata muscleDataList) {
                this.id = muscleDataList.getId();
                this.muscle = muscleDataList.getMuscle();
                this.date = muscleDataList.getCreatedAt();
            }
        }
    }

    @Data
    public static class MyChangeWeightDTO {
        private Integer id;
        private Double golWeight;
        private List<WeightDataListDTO> weightDataList;

        public MyChangeWeightDTO(User user, List<Bodydata> weightDataList) {
            this.id = user.getId();
            this.golWeight = user.getGoalWeight();
            this.weightDataList = weightDataList.stream().map(WeightDataListDTO::new).toList();
        }

        @Data
        public static class WeightDataListDTO {
            private Integer id;
            private Double weight;
            private Timestamp date;

            public WeightDataListDTO(Bodydata muscleDataList) {
                this.id = muscleDataList.getId();
                this.weight = muscleDataList.getWeight();
                this.date = muscleDataList.getCreatedAt();
            }
        }
    }

    @Data
    public static class GoalFatUpdateDTO {
        private Integer id;
        private Double goalFat;

        public GoalFatUpdateDTO(User user) {
            this.id = user.getId();
            this.goalFat = user.getGoalFat();
        }
    }

    @Data
    public static class GoalMuscleUpdateDTO {
        private Integer id;
        private Double goalMuscle;

        public GoalMuscleUpdateDTO(User user) {
            this.id = user.getId();
            this.goalMuscle = user.getGoalMuscle();
        }
    }

    @Data
    public static class GoalWeightUpdateDTO {
        private Integer id;
        private Double goalWeight;

        public GoalWeightUpdateDTO(User user) {
            this.id = user.getId();
            this.goalWeight = user.getGoalWeight();
        }
    }
}