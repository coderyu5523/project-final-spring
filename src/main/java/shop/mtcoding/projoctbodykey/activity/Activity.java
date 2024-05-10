package shop.mtcoding.projoctbodykey.activity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

@Data
@Table(name = "activity_tb")
@Entity
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Integer walking; // 걸음수
    private Integer drinkWater; // 물 횟수
    private Timestamp createdAt;

    @Builder
    public Activity(Integer id, User user, Integer walking, Integer drinkWater, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.walking = walking;
        this.drinkWater = drinkWater;
        this.createdAt = createdAt;
    }
}
