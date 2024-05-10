package shop.mtcoding.projoctbodykey.meal;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;
import shop.mtcoding.projoctbodykey.activity.Activity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Table(name = "meal_tb")
@Entity
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Activity activity;

    private String mealImg; // 식단 사진명
    private LocalDateTime eatTime; // 먹은 시간
    private Timestamp createdAt; // 변경된 부분: LocalDateTime 대신 Timestamp 사용

    @Builder
    public Meal(Integer id, Activity activity, String mealImg, LocalDateTime eatTime, Timestamp createdAt) {
        this.id = id;
        this.activity = activity;
        this.mealImg = mealImg;
        this.eatTime = eatTime;
        this.createdAt = createdAt;
    }
}