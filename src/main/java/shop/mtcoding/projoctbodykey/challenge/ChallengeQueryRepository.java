package shop.mtcoding.projoctbodykey.challenge;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Repository
@Component
public class ChallengeQueryRepository {
    private final EntityManager em;

    public ChallengeResponse.ChallengeDTO findByUserChallenge(Integer userId) {
        String q = """
            SELECT c.id, c.challenge_name, c.sub_title, ac.closing_time, c.coin, ac.status
            FROM challenge_tb c
            LEFT JOIN attend_challenge_tb ac ON c.id = ac.challenge_id
            WHERE ac.user_id = ? AND ac.status IS NULL;
            """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, userId);

        Object[] result = (Object[]) query.getSingleResult();

        // DTO 객체 생성
        ChallengeResponse.ChallengeDTO challengeDTO = new ChallengeResponse.ChallengeDTO();
        challengeDTO.setId((Integer) result[0]);
        challengeDTO.setChallengeName((String) result[1]);
        challengeDTO.setSubtitle((String) result[2]);
        challengeDTO.setClosingTime((Timestamp) result[3]);
        challengeDTO.setCoin((Integer) result[4]);
        challengeDTO.setStatus((Boolean) result[5]);

        return challengeDTO;
    }

}
