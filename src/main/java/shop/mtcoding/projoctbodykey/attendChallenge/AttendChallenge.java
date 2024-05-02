package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;


@NoArgsConstructor
@Data
@Table(name = "attendChallenge_tb")
@Entity
public class AttendChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Integer totalWalking; // 걸음수 합산


    @ManyToOne(fetch = FetchType.LAZY)
    private Challenge challenge;

    private Timestamp openingTime; // 챌린지 시작 시간
    private Timestamp closingTime; // 챌린지 마감 시간
    private Boolean status ; // 성공 실패 참여 중
    private Timestamp createdAt;

    @Builder
    public AttendChallenge(Integer id, User user, Integer totalWalking, Challenge challenge, Timestamp openingTime, Timestamp closingTime, Boolean status, Timestamp createdAt) {
        this.id = id;
        this.user = user;
        this.totalWalking = totalWalking;
        this.challenge = challenge;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.status = status;
        this.createdAt = createdAt;
    }
}
