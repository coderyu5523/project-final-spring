package shop.mtcoding.projoctbodykey.bodydata;

import lombok.Builder;
import lombok.Data;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;
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
        private Double golFat;
        private Double golMuscle;
        private Double golWeight;
        private List<FatTimeLineDTO> fatTimeLine;
        private List<MuscleTimeLineDTO> muscleTimeLine;
        private List<WeightTimeLineDTO> weightTimeLine;

        public BodyDateDTO(User user, BodyData bodyData, List<BodyData> bodyDataTimeLine) {
            this.userId = user.getId();
            if(bodyData != null) {
                this.fat = Optional.ofNullable(bodyData.getFat()).orElse(null);
                this.muscle = Optional.ofNullable(bodyData.getMuscle()).orElse(null);
                this.weight = Optional.ofNullable(bodyData.getWeight()).orElse(null);
            }
            this.golFat = user.getGoalFat();
            this.golMuscle = user.getGoalMuscle();
            this.golWeight = user.getGoalWeight();
            this.fatTimeLine = bodyDataTimeLine.stream().map(FatTimeLineDTO::new).toList();
            this.muscleTimeLine = bodyDataTimeLine.stream().map(MuscleTimeLineDTO::new).toList();
            this.weightTimeLine = bodyDataTimeLine.stream().map(WeightTimeLineDTO::new).toList();
        }


        @Data
        public static class FatTimeLineDTO {
            private Integer bodyDateId;
            private Double fat;
            private Timestamp fatTimeLine;

            public FatTimeLineDTO(BodyData bodyData) {
                this.bodyDateId = bodyData.getId();
                this.fat = bodyData.getFat();
                this.fatTimeLine = bodyData.getCreatedAt();
            }
        }

        @Data
        public static class MuscleTimeLineDTO {
            private Integer bodyDateId;
            private Double muscle;
            private Timestamp muscleTimeLine;

            public MuscleTimeLineDTO(BodyData bodyData) {
                this.bodyDateId = bodyData.getId();
                this.muscle = bodyData.getMuscle();
                this.muscleTimeLine = bodyData.getCreatedAt();
            }
        }

        @Data
        public static class WeightTimeLineDTO {
            private Integer bodyDateId;
            private Double weight;
            private Timestamp weightTimeLine;

            public WeightTimeLineDTO(BodyData bodyData) {
                this.bodyDateId = bodyData.getId();
                this.weight = bodyData.getWeight();
                this.weightTimeLine = bodyData.getCreatedAt();
            }
        }
    }
}
