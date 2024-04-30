package shop.mtcoding.projoctbodykey.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ChallengeJPARepositoryTest {

    @Autowired
    private ChallengeJPARepository challengeJPARepository;

    @Test
    public void findBodySevenByUserId_test(){
        // given
        Integer userId = 1;

        // when
        List<Challenge> challengeList = challengeJPARepository.findAllChallengeIdNull(userId);

        // eye
        System.out.println("challengeList = " + challengeList.toString());
    }

    @Test
    public void partChallenges_test(){
        // given
        Integer userId = 1;

        // when
        List<Challenge> challengeList = challengeJPARepository.partChallenges(userId);

        // eye
        System.out.println("challengeList = " + challengeList.toString());
    }

    @Test
    public void findByUserChallenge_test(){
        // given
        Integer userId = 1;

        // when
        Challenge challenge = challengeJPARepository.findByUserChallenge(userId).orElseThrow();

        // eye
        System.out.println(challenge);
    }
}
