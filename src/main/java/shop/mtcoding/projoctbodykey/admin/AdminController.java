package shop.mtcoding.projoctbodykey.admin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey.activity.ActivityService;
import shop.mtcoding.projoctbodykey.user.UserService;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;
    private final ActivityService activityService;

    private final HttpSession session;

    // 로그인 폼
    @GetMapping("/admin")
    public String loginForm() {
        return "/admin/login-form";
    }

    @PostMapping("/admin/login")
    public String login() {
        return "redirect:/admin/challenges";
    }

    @GetMapping("/admin/logout")
    public String logout() {
        return "redirect:/admin";
    }

}
