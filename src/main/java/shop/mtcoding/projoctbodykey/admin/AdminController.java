package shop.mtcoding.projoctbodykey.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey.AttendChallenge.AttendChallengeService;
import shop.mtcoding.projoctbodykey.Challenge.Challenge;
import shop.mtcoding.projoctbodykey.activity.ActivityService;
import shop.mtcoding.projoctbodykey.food.FoodService;
import shop.mtcoding.projoctbodykey.user.UserService;
import shop.mtcoding.projoctbodykey.Challenge.ChallengeRequest;
import shop.mtcoding.projoctbodykey.Challenge.ChallengeService;

import java.util.List;

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
        return "redirect:/admin/challenge/list";
    }

    @GetMapping("/admin/logout")
    public String logout() {
        return "redirect:/admin";
    }

}
