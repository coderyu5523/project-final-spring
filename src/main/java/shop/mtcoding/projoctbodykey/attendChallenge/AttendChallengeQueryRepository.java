package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.mtcoding.projoctbodykey.challenge.ChallengeResponse;

@RequiredArgsConstructor
@Repository
public class AttendChallengeQueryRepository {
    private final EntityManager em;
}
