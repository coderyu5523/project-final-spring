package shop.mtcoding.projoctbodykey.activity;

import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class ActivityRequest {
    @Data
    public static class findWithWeakWorking {
        private Integer walking;
        private Timestamp date;

        public findWithWeakWorking(Activity activity) {
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
}
