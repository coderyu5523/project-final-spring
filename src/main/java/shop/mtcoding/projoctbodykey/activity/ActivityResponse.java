package shop.mtcoding.projoctbodykey.activity;

import lombok.Data;
import shop.mtcoding.projoctbodykey.body.Body;

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
        private List<BodyDTO> bodys = new ArrayList<>();

        public mainDTO(List<Body> bodyList) {
            this.username = username;
            this.goalfat = goalfat;
            this.fat = fat;
            this.goalmuscle = goalmuscle;
            this.muscle = muscle;
            this.walking = walking;
            this.drinkWater = drinkWater;
            this.mealCount = mealCount;
            this.bodys = bodyList.stream().map(BodyDTO::new).toList();
        }

        static class BodyDTO{
            private double weight;
            private double muscle;
            private double fat;
            private String createdAt;

            public BodyDTO(Body body) {
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
