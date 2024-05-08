package shop.mtcoding.projoctbodykey.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey._core.utils.JwtVO;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/api/users/my-change-fat")
    public ResponseEntity<?> myChangeFat() {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.MyChangeFatDTO respDTO = userService.myChangeFat(user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @GetMapping("/api/users/my-change-muscle")
    public ResponseEntity<?> myChangeMuscle() {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.MyChangeMuscleDTO respDTO = userService.myChangeMuscle(user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @GetMapping("/api/users/my-change-weight")
    public ResponseEntity<?> myChangeWeight() {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.MyChangeWeightDTO respDTO = userService.myChangeWeight(user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @GetMapping("/api/users/myPage")
    public ResponseEntity<?> myPage() {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.MyPageDTO respDTO = userService.myPage(user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @GetMapping("/api/users")
    public ResponseEntity<?> mainPage() {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.MainPageDTO respDTO = userService.mainPage(user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @GetMapping("/api/users/update-form")
    public ResponseEntity<?> updateForm() {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.UpdateFormDTO respDTO = userService.updateForm(user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody UserRequest.JoinDTO reqDTO) {

        return ResponseEntity.ok(new ApiUtil<>(userService.join(reqDTO)));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest.LoginDTO reqDTO) {
        UserResponse.LoginDTO user = userService.login(reqDTO);

        // jwt 생성
        return ResponseEntity.ok()
                .header(JwtVO.HEADER, JwtVO.PREFIX + user.accessToken())
                .body(new ApiUtil<>(user));
    }

    @PutMapping("/api/users/update")
    public ResponseEntity<?> update(@RequestBody UserRequest.UpdateDTO reqDTO) throws IOException {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.UpdateDTO respDTO = userService.update(reqDTO, user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @PutMapping("/api/users/goalFat-update")
    public ResponseEntity<?> goalFatUpdate(@RequestBody UserRequest.GoalFatUpdateDTO reqDTO) {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.GoalFatUpdateDTO respDTO = userService.goalFatUpdate(reqDTO, user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @PutMapping("/api/users/goalMuscle-update")
    public ResponseEntity<?> goalMuscleUpdate(@RequestBody UserRequest.GoalMuscleUpdateDTO reqDTO) {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.GoalMuscleUpdateDTO respDTO = userService.goalMuscleUpdate(reqDTO, user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @PutMapping("/api/users/goalWeight-update")
    public ResponseEntity<?> goalWeightUpdate(@RequestBody UserRequest.GoalWeightUpdateDTO reqDTO) {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        UserResponse.GoalWeightUpdateDTO respDTO = userService.goalWeightUpdate(reqDTO, user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }
}
