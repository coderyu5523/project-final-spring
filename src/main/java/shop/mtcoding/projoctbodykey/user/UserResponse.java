package shop.mtcoding.projoctbodykey.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserResponse {

    @Data
    public static class JoinDTO {
        private Integer id;
        private String name;
        private String username;
        private String birth;
        private Character gender;
        private Double height;

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
        private String name;
        private Double fat;
        private Double muscle;
        private Double weight;
        private List<ConqueredChallengeDTO> conqueredChallenge;
        private String userImg;

        public MyPageDTO(User user, BodyData bodyData, List<Object[]> conqueredChallenge) {
            this.id = user.getId();
            this.name = user.getName();
            if (bodyData != null) {
                this.fat = bodyData.getFat();
                this.muscle = bodyData.getMuscle();
                this.weight = bodyData.getWeight();
                this.conqueredChallenge = conqueredChallenge.stream().map(partChallenge -> new ConqueredChallengeDTO(partChallenge, (String) partChallenge[4])).toList();
                try {
                    this.userImg = ImageUtil.encode(user.getUserImg());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.fat = 0.0d;
                this.muscle = 0.0d;
                this.weight = 0.0d;
            }
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
            if (user.getUserImg() != null) {
                try {
                    this.userImg = ImageUtil.encode(user.getUserImg());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                this.userImg = null;
            }
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer id;
        private String name;
        private String phone;
        private Double height;

        public UpdateDTO(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.phone = user.getPhone();
            this.height = user.getHeight();
        }
    }

    @Data
    public static class ImgUpdateDTO {
        private Integer id;
        private String userImg;

        public ImgUpdateDTO(Integer userId, String userImg) {
            this.id = userId;
            this.userImg = userImg;
                try {
                    this.userImg = ImageUtil.encode(userImg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @Data
    public static class MainPageDTO {
        private Integer id;
        private String name;
        private Double goalFat; // 사용자의 목표 지방량
        private Double goalMuscle; // 사용자의 목표 근육량
        private Double goalWeight; // 사용자의 목표 근육량

        // 가장 최근 지방량, 근육량, 체중
        private Double fat;
        private Double muscle;
        private Double weight;
        private List<BodyDataDTO> bodyData;

        public MainPageDTO(User user, BodyData bodyData, List<BodyData> bodyDataList) {
            this.id = user.getId();
            this.name = user.getName();
            this.goalFat = Optional.ofNullable(user.getGoalFat()).orElse(0.0);
            this.goalMuscle = Optional.ofNullable(user.getGoalMuscle()).orElse(0.0);
            this.goalWeight = Optional.ofNullable(user.getGoalWeight()).orElse(0.0);
            if (bodyData != null) {
                this.fat = Optional.ofNullable(bodyData.getFat()).orElse(0.0);
                this.muscle = Optional.ofNullable(bodyData.getMuscle()).orElse(0.0);
                this.weight = Optional.ofNullable(bodyData.getWeight()).orElse(0.0);
                this.bodyData = bodyDataList.stream().map(BodyDataDTO::new).toList();
            } else {
                this.fat = 0.0d;
                this.muscle = 0.0d;
                this.weight = 0.0d;
                this.bodyData = new ArrayList<>();
                // 배열 초기화 및 요소 추가
                this.bodyData.add(new BodyDataDTO(1, 0.0d, 0.0d, 0.0d, user.getCreatedAt()));
            }
        }

        @Data
        public static class BodyDataDTO {
            private Integer id;
            private Double fat;
            private Double muscle;
            private Double weight;
            private Timestamp date;

            public BodyDataDTO(BodyData bodyData) {
                this.id = bodyData.getId();
                this.fat = bodyData.getFat();
                this.muscle = bodyData.getMuscle();
                this.weight = bodyData.getWeight();
                this.date = bodyData.getCreatedAt();
            }

            public BodyDataDTO(Integer id, Double fat, Double muscle, Double weight, Timestamp date) {
                this.id = id;
                this.fat = fat;
                this.muscle = muscle;
                this.weight = weight;
                this.date = date;
            }
        }
    }


    @Data
    public static class MyChangeFatDTO {
        private Integer id;
        private Double golFat;
        private List<fatDataListDTO> fatDataList;

        public MyChangeFatDTO(User user, List<BodyData> fatDataList) {
            this.id = user.getId();
            if (user.getGoalFat() != null) {
                this.golFat = user.getGoalFat();
            } else {
                this.golFat = 0.0d;
            }
            if (fatDataList.isEmpty()) {
                this.fatDataList = new ArrayList<>();
                // 배열 초기화 및 요소 추가
                this.fatDataList.add(new fatDataListDTO(1, 0.0d, user.getCreatedAt()));
            } else {
                this.fatDataList = fatDataList.stream().map(fatDataListDTO::new).toList();
            }
        }

        @Data
        public static class fatDataListDTO {
            private Integer id;
            private Double fat;
            private Timestamp date;

            public fatDataListDTO(BodyData fatDataList) {
                this.id = fatDataList.getId();
                this.fat = fatDataList.getFat();
                this.date = fatDataList.getCreatedAt();
            }

            public fatDataListDTO(Integer id, Double fat, Timestamp date) {
                this.id = id;
                this.fat = fat;
                this.date = date;
            }
        }
    }

    @Data
    public static class MyChangeMuscleDTO {
        private Integer id;
        private Double golMuscle;
        private List<MuscleDataListDTO> muscleDataList;

        public MyChangeMuscleDTO(User user, List<BodyData> muscleDataList) {
            this.id = user.getId();
            if (user.getGoalMuscle() != null) {
                this.golMuscle = user.getGoalMuscle();
            } else {
                this.golMuscle = 0.0d;
            }
            if (muscleDataList.isEmpty()) {
                this.muscleDataList = new ArrayList<>();
                // 배열 초기화 및 요소 추가
                this.muscleDataList.add(new MuscleDataListDTO(1, 0.0d, user.getCreatedAt()));
            } else {
                this.muscleDataList = muscleDataList.stream().map(MuscleDataListDTO::new).toList();
            }
        }

        @Data
        public static class MuscleDataListDTO {
            private Integer id;
            private Double muscle;
            private Timestamp date;

            public MuscleDataListDTO(BodyData muscleDataList) {
                this.id = muscleDataList.getId();
                this.muscle = muscleDataList.getMuscle();
                this.date = muscleDataList.getCreatedAt();
            }

            public MuscleDataListDTO(Integer id, Double muscle, Timestamp date) {
                this.id = id;
                this.muscle = muscle;
                this.date = date;
            }
        }
    }

    @Data
    public static class MyChangeWeightDTO {
        private Integer id;
        private Double golWeight;
        private List<WeightDataListDTO> weightDataList;

        public MyChangeWeightDTO(User user, List<BodyData> weightDataList) {
            this.id = user.getId();
            if (user.getGoalWeight() != null) {
                this.golWeight = user.getGoalWeight();
            } else {
                this.golWeight = 0.0d;
            }
            if (weightDataList.isEmpty()) {
                this.weightDataList = new ArrayList<>();
                // 배열 초기화 및 요소 추가
                this.weightDataList.add(new WeightDataListDTO(1, 0.0d, user.getCreatedAt()));
            } else {
                this.weightDataList = weightDataList.stream().map(WeightDataListDTO::new).toList();
            }
        }

        @Data
        public static class WeightDataListDTO {
            private Integer id;
            private Double weight;
            private Timestamp date;

            public WeightDataListDTO(BodyData muscleDataList) {
                this.id = muscleDataList.getId();
                this.weight = muscleDataList.getWeight();
                this.date = muscleDataList.getCreatedAt();
            }

            public WeightDataListDTO(Integer id, Double weight, Timestamp date) {
                this.id = id;
                this.weight = weight;
                this.date = date;
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