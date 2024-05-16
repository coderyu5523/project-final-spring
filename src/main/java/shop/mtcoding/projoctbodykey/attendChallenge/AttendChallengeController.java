package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey.challenge.ChallengeResponse;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserService;

@RequiredArgsConstructor
@RestController
public class AttendChallengeController {
    private final AttendChallengeService attendChallengeService;
    private final HttpSession session;

    @PostMapping("/api/attend-challenge-save")
    public ResponseEntity<?> save(@RequestBody AttendChallengeRequest.SaveDTO reqDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        AttendChallengeResponse.SaveDTO respDTO = attendChallengeService.save(sessionUser, reqDTO);
        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @PutMapping("/api/attend-challenges/status-update")
    public ResponseEntity<?> statusUpdate(@RequestBody AttendChallengeRequest.StatusUpdateDTO reqDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        ChallengeResponse.UpcomingChallengesDTO respDTO = attendChallengeService.statusUpdate(sessionUser, reqDTO);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }
}
