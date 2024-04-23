package shop.mtcoding.projoctbodykey.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey.whichChallenge.WhichChallenge;
import shop.mtcoding.projoctbodykey.whichChallenge.WhichChallengeJPARepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeJPARepository challengeJPARepository;
}
