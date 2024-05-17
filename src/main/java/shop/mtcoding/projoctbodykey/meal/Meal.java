package shop.mtcoding.projoctbodykey.meal;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;
import shop.mtcoding.projoctbodykey.activity.Activity;
import shop.mtcoding.projoctbodykey.user.User;

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
    private User user;

    private String mealImg;
    private String eatTime; // 먹은 시간 ex) 아침, 점심, 저녁, 간식
    private Timestamp createdAt; // 변경된 부분: LocalDateTime 대신 Timestamp 사용

    @Builder
    public Meal(Integer id, User user, String mealImg, String eatTime, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.mealImg = mealImg;
        this.eatTime = eatTime;
        this.createdAt = createdAt;
    }
}