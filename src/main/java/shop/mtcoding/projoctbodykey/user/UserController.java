package shop.mtcoding.projoctbodykey.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final HttpSession session;
    //todo @PostMapping("/join") 회원가입
    //todo @PostMapping("/login") 로그인
    //todo @GetMapping("/logout") 로그아웃

    //todo  메인페이지 마이페이지 주소 고민
    //todo @GetMapping("/api/users") 메인페이지
    //todo @GetMapping("/api/users/{userId} 마이페이지
    //todo @PutMapping("/api/users/{userId} 회원정보 수정



//
//    //로그인
//    @PostMapping("/login")
//
//    //로그아웃
//    @GetMapping("/logout")
}
