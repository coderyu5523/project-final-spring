package shop.mtcoding.projoctbodykey.activity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class ActivityRequest {
    @Data
    public static class WeakWater{
        private Integer water;
        private Timestamp date;

        public WeakWater(Activity activity) {
            this.water = activity.getDrinkWater();
            this.date = activity.getCreatedAt();
        }
    }

    @Data
    public static class WeakWalking {
        private Integer walking;
        private Timestamp date;

        public WeakWalking(Activity activity) {
            this.walking = activity.getWalking();
            this.date = activity.getCreatedAt();
        }
    }
    @Data
    public static class WalkingToatalAndAVG {
        private Long totalMonthWalking;
        private double avgMonthWalking;
    }

    @Data
    public static class WalkingRateAvG {
        private Long rateAvgWalking;

    }

    @Data
    public static class MaxWalkingDay {
        private Integer maxWalking;
        private Timestamp maxWalkingDay;

    }

    @Data
    public static class UpdateDTO {

        @Min(value = 0, message = "0 이상의 값만 입력하여 주세요")
        @Max(value = 100000, message = "걸음수가 너무 많이 들어왔어요")
        private Integer walking;

        @Min(value = 0, message = "0 이상의 값만 입력하여 주세요")
        @Max(value = 2100, message = "2100 이하의 값만 입력하여 주세요")
        private Integer water;
    }

    // 아래는 걷기, 물 따로 업데이트 하는거
    @Data
    public static class WalkingUpdateDTO {

        @Min(value = 0, message = "0 이상의 값만 입력하여 주세요")
        @Max(value = 100000, message = "걸음수는 100000 이하로 입력하여 주세요")
        private Integer walking;
    }

    @Data
    public static class WaterUpdateDTO {

        @Min(value = 0, message = "0 이상의 값만 입력하여 주세요")
        @Max(value = 3000, message = "마신 물양은 3000 이하로 입력하여 주세요")
        private Integer water;
    }
}
