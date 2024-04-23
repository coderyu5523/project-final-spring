package shop.mtcoding.projoctbodykey.Challenge;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ChallengeQueryRepository {
    private final EntityManager em;
}
