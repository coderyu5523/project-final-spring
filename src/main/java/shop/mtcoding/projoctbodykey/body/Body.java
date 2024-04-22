package shop.mtcoding.projoctbodykey.body;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.whichChallenge.WhichChallenge;

import java.sql.Timestamp;


@NoArgsConstructor
@Data
@Table(name = "body_tb")
@Entity
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private double weight;
    private double muscle;
    private double fat;
    private Timestamp createdAt;

    @Builder

    public Body(Integer id, User user, double weight, double muscle, double fat, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.weight = weight;
        this.muscle = muscle;
        this.fat = fat;
        this.createdAt = createdAt;
    }
}
