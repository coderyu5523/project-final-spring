package shop.mtcoding.projoctbodykey.meal;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.activity.Activity;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "meal_tb")
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Activity activity;

    private String mealImg; // 식단 사진명
    private Timestamp eatTime; // 먹은 시간
    private Timestamp createdAt;

    @Builder
    public Meal(Integer id, String mealImg, Timestamp eatTime, Timestamp createdAt) {
        this.id = id;
        this.mealImg = mealImg;
        this.eatTime = eatTime;
        this.createdAt = createdAt;
    }
}
