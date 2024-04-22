package shop.mtcoding.projoctbodykey.whichChallenge;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "whichChallengenge_tb")
@Entity
public class WhichChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String challengeName; // 챌린지명
    private String challengeFilename;// 챌린지 사진경로
    private Integer meter; // 산 높이
    private String badgeFilename; // 뱃지 사진 경로
    private String location; // 산 지역
    private String content;  // 챌린지 내용


    @Builder
    public WhichChallenge(Integer id, String challengeName, String challengeFilename, Integer meter, String badgeFilename, String location, String content) {
        this.id = id;
        this.challengeName = challengeName;
        this.challengeFilename = challengeFilename;
        this.meter = meter;
        this.badgeFilename = badgeFilename;
        this.location = location;
        this.content = content;
    }
}
