package shop.mtcoding.projoctbodykey.challenge;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Objects;

@Import(ChallengeQueryRepository.class)
@DataJpaTest
public class ChallengeRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ChallengeQueryRepository challengeQueryRepository;

    @Test
    public void findByUserChallenge_test() {
        int userId = 1;

        System.out.println(challengeQueryRepository.findByUserChallenge(userId));
    }

    @Test
    public void partChallenges_test() {
        int userId = 1;

        System.out.println(challengeQueryRepository.partChallenges(userId));
    }
}
