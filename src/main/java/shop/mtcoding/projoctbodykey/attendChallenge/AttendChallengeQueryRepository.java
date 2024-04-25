package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AttendChallengeQueryRepository {
    private final EntityManager em;
}
