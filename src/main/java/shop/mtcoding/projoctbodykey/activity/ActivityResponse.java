package shop.mtcoding.projoctbodykey.activity;

import lombok.Data;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;

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


}
