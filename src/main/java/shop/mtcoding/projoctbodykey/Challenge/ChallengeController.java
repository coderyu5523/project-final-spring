package shop.mtcoding.projoctbodykey.Challenge;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChallengeController {
    private final ChallengeService challengeService;
    private final HttpSession session ;
}
