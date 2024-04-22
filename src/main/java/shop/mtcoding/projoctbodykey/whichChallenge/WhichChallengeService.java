package shop.mtcoding.projoctbodykey.whichChallenge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WhichChallengeService {
    private final WhichChallengeJPARepository whichChallengeJPARepository;
}
