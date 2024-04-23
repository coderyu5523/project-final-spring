package shop.mtcoding.projoctbodykey.AttendChallenge;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AttendChallengeController {
    private final AttendChallengeService attendChallengeService;
    private final HttpSession session;

}
