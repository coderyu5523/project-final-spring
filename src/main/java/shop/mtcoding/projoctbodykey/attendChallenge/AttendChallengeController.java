package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey.user.SessionUser;

@RequiredArgsConstructor
@RestController
public class AttendChallengeController {
    private final AttendChallengeService attendChallengeService;
    private final HttpSession session;

//    @PostMapping("/api/attend-challenge-save")
//    public ResponseEntity<?> save(@RequestBody AttendChallengeRequest.SaveDTO reqDTO) {
//        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
//        AttendChallengeResponse.SaveDTO respDTO = attendChallengeService.save(user, reqDTO);
//        return ResponseEntity.ok(new ApiUtil<>(respDTO));
//    }
}
