package shop.mtcoding.projoctbodykey.AttendChallenge;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AttendChallengeQueryRepository {
    private final EntityManager em;
}
