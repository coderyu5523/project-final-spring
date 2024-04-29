package shop.mtcoding.projoctbodykey.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey._core.utils.JwtVO;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final HttpSession session;

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
                .body(new ApiUtil(user));
    }

    //todo @GetMapping("/logout") 로그아웃

    //todo  메인페이지 마이페이지 주소 고민
    //todo @GetMapping("/api/users") 메인페이지
//    @GetMapping("/api/myPage/{userId}")
//    public ResponseEntity<?> myPage(@PathVariable Integer userId) {
//        User user = (User) session.getAttribute("SessionUser");
//
//        UserResponse.MyPageDTO respDTO =  userService.myPage(userId);
//
//        return  ResponseEntity.ok(new ApiUtil<>(respDTO));
//    }

    //todo @PutMapping("/api/users/{userId} 회원정보 수정



//
//    //로그인
//    @PostMapping("/login")
//
//    //로그아웃
//    @GetMapping("/logout")
}
