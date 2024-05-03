package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserService;

@RequiredArgsConstructor
@RestController
public class AttendChallengeController {
    private final AttendChallengeService attendChallengeService;
    private final HttpSession session;
    private final UserService userService;

    @PostMapping("/api/attend-challenge-save")
    public ResponseEntity<?> save(@RequestBody AttendChallengeRequest.SaveDTO reqDTO) {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        User sessionUser = userService.findById(user.getId());
        AttendChallengeResponse.SaveDTO respDTO = attendChallengeService.save(sessionUser, reqDTO);
        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }
}
