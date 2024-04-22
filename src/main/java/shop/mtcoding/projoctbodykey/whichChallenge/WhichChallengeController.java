package shop.mtcoding.projoctbodykey.whichChallenge;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WhichChallengeController {
    private final WhichChallengeService whichChallengeService;
    private final HttpSession session ;
}
