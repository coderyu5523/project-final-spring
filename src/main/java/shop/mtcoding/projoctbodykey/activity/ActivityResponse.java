package shop.mtcoding.projoctbodykey.activity;

import lombok.Data;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ActivityResponse {

    @Data
    static class mainDTO{
        private String username;
        private double goalfat;
        private double fat;
        private double goalmuscle;
        private double muscle;
        private Integer walking;
        private Integer drinkWater;
        private Integer mealCount;
        private List<BodydataDTO> bodys = new ArrayList<>();

        public mainDTO(List<BodyData> bodyList) {
            this.username = username;
            this.goalfat = goalfat;
            this.fat = fat;
            this.goalmuscle = goalmuscle;
            this.muscle = muscle;
            this.walking = walking;
            this.drinkWater = drinkWater;
            this.mealCount = mealCount;
            this.bodys = bodyList.stream().map(BodydataDTO::new).toList();
        }

        static class BodydataDTO{
            private double weight;
            private double muscle;
            private double fat;
            private String createdAt;

            public BodydataDTO(BodyData body) {
                this.weight = body.getWeight();
                this.muscle = body.getMuscle();
                this.fat = body.getFat();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String Date = body.getCreatedAt().toLocalDateTime().format(formatter);
                this.createdAt =Date;
            }
        }
    }

    @Data
    static class WalkingDetail {
        private Integer dayWalking;
        private Long totalMonthWalking;
        private double avgMonthWalking;
        private double rateAvgWalking;
        private Integer maxWalking;
        private Timestamp maxWalkingDay;
        private List<WeakWalkingDTO> weakWalkings;

        @Data
        public class WeakWalkingDTO{
            private Timestamp date;
            private Integer walking;

            public WeakWalkingDTO(ActivityRequest.findWithWeakWorking weakWalking) {
                this.date = weakWalking.getDate();
                this.walking = weakWalking.getWalking();
            }
        }

        public WalkingDetail(Integer dayWalking, ActivityRequest.WalkingToatalAndAVG  WalkingToatalAndAVG,
                             double rateAvgWalking, ActivityRequest.MaxWalkingDay maxWalking, List<ActivityRequest.findWithWeakWorking> weakWalkings) {
            this.dayWalking = dayWalking;
            this.totalMonthWalking = WalkingToatalAndAVG.getTotalMonthWalking();
            this.avgMonthWalking = (int) (WalkingToatalAndAVG.getAvgMonthWalking()* 100) / 100.0;
            this.rateAvgWalking = (int) (rateAvgWalking * 100) / 100.0;
            this.maxWalking = maxWalking.getMaxWalking();
            this.maxWalkingDay = maxWalking.getMaxWalkingDay();
            this.weakWalkings = weakWalkings.stream().map(WeakWalkingDTO::new).toList();
        }
    }

}
