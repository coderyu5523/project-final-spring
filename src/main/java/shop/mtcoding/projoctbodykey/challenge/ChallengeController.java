package shop.mtcoding.projoctbodykey.challenge;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class ChallengeController {
    private final ChallengeService challengeService;
    private final HttpSession session;

    @GetMapping("/api/challenges/{id}")
    public ResponseEntity<?> challengeDetail(@PathVariable("id") Integer id) throws IOException {
        ChallengeResponse.DetailDTO reqDTO = challengeService.detail(id);
        return ResponseEntity.ok(new ApiUtil(reqDTO));
    }

    @GetMapping("/api/challenges")
    public ResponseEntity<?> challenges() throws IOException {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        ChallengeResponse.ChallengesDTO reqDTO = challengeService.challenges(user);
        return ResponseEntity.ok(new ApiUtil(reqDTO));
    }
}
