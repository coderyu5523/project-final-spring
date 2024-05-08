package shop.mtcoding.projoctbodykey.bodydata;

import lombok.Builder;
import lombok.Data;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserResponse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BodyDataResponse {

    @Data
    public static class SaveDTO {
        private Integer userId;
        private Double fat;
        private Double muscle;
        private Double weight;

        @Builder
        public SaveDTO(BodyData bodyData) {
            this.userId = bodyData.getUser().getId();
            this.fat = bodyData.getFat();
            this.muscle = bodyData.getMuscle();
            this.weight = bodyData.getWeight();
        }
    }

    @Data
    public static class BodyDateDTO {
        private Integer userId;
        private Double fat;
        private Double muscle;
        private Double weight;
        private Double goalFat;
        private Double goalMuscle;
        private Double goalWeight;
        private List<FatTimeLineDTO> fatTimeLine;
        private List<MuscleTimeLineDTO> muscleTimeLine;
        private List<WeightTimeLineDTO> weightTimeLine;

        public BodyDateDTO(User user, BodyData bodyData, List<BodyData> bodyDataTimeLine) {
            this.userId = user.getId();
            this.goalFat = Optional.ofNullable(user.getGoalFat()).orElse(0.0);
            this.goalMuscle = Optional.ofNullable(user.getGoalMuscle()).orElse(0.0);
            this.goalWeight = Optional.ofNullable(user.getGoalWeight()).orElse(0.0);
            if(bodyData != null) {
                this.fat = bodyData.getFat();
                this.muscle = bodyData.getMuscle();
                this.weight = bodyData.getWeight();
                this.fatTimeLine = bodyDataTimeLine.stream().map(FatTimeLineDTO::new).toList();
                this.muscleTimeLine = bodyDataTimeLine.stream().map(MuscleTimeLineDTO::new).toList();
                this.weightTimeLine = bodyDataTimeLine.stream().map(WeightTimeLineDTO::new).toList();
            } else {
                this.fat = 0.0d;
                this.muscle = 0.0d;
                this.weight = 0.0d;
                this.fatTimeLine = new ArrayList<>();
                // 배열 초기화 및 요소 추가
                this.fatTimeLine.add(new FatTimeLineDTO(1, 0.0d, user.getCreatedAt()));
                this.muscleTimeLine = new ArrayList<>();
                // 배열 초기화 및 요소 추가
                this.muscleTimeLine.add(new MuscleTimeLineDTO(1, 0.0d, user.getCreatedAt()));
                this.weightTimeLine = new ArrayList<>();
                // 배열 초기화 및 요소 추가
                this.weightTimeLine.add(new WeightTimeLineDTO(1, 0.0d, user.getCreatedAt()));
            }
        }

        @Data
        public static class FatTimeLineDTO {
            private Integer bodyDateId;
            private Double fat;
            private Timestamp fatTimeLine;

            public FatTimeLineDTO(BodyData bodyData) {
                if(bodyData != null) {
                    this.bodyDateId = bodyData.getId();
                    this.fat = bodyData.getFat();
                    this.fatTimeLine = bodyData.getCreatedAt();
                } else {
                    this.bodyDateId = null;
                    this.fat = 0.0d;
                    this.fatTimeLine = null;
                }
            }

            public FatTimeLineDTO(Integer bodyDateId, Double fat, Timestamp fatTimeLine) {
                this.bodyDateId = bodyDateId;
                this.fat = fat;
                this.fatTimeLine = fatTimeLine;
            }
        }

        @Data
        public static class MuscleTimeLineDTO {
            private Integer bodyDateId;
            private Double muscle;
            private Timestamp muscleTimeLine;

            public MuscleTimeLineDTO(BodyData bodyData) {
                if(bodyData != null) {
                    this.bodyDateId = bodyData.getId();
                    this.muscle = bodyData.getMuscle();
                    this.muscleTimeLine = bodyData.getCreatedAt();
                } else {
                    this.bodyDateId = null;
                    this.muscle = 0.0d;
                    this.muscleTimeLine = null;
                }
            }

            public MuscleTimeLineDTO(Integer bodyDateId, Double muscle, Timestamp muscleTimeLine) {
                this.bodyDateId = bodyDateId;
                this.muscle = muscle;
                this.muscleTimeLine = muscleTimeLine;
            }
        }

        @Data
        public static class WeightTimeLineDTO {
            private Integer bodyDateId;
            private Double weight;
            private Timestamp weightTimeLine;

            public WeightTimeLineDTO(BodyData bodyData) {
                if(bodyData != null) {
                    this.bodyDateId = bodyData.getId();
                    this.weight = bodyData.getWeight();
                    this.weightTimeLine = bodyData.getCreatedAt();
                } else {
                    this.bodyDateId = null;
                    this.weight = 0.0d;
                    this.weightTimeLine = null;
                }
            }

            public WeightTimeLineDTO(Integer bodyDateId, Double weight, Timestamp weightTimeLine) {
                this.bodyDateId = bodyDateId;
                this.weight = weight;
                this.weightTimeLine = weightTimeLine;
            }
        }
    }
}
