package shop.mtcoding.projoctbodykey.admin;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.projoctbodykey.activity.ActivityService;
import shop.mtcoding.projoctbodykey.challenge.ChallengeService;
import shop.mtcoding.projoctbodykey.food.FoodService;
import shop.mtcoding.projoctbodykey.user.UserService;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;
    private final ActivityService activityService;
    private final ChallengeService challengeService;
    private final FoodService foodService;
    private final HttpSession session;

    // 로그인 폼
    @GetMapping("/admin")
    public String loginForm() {
        return "/admin/login-form";
    }

    @PostMapping("/admin/login")
    public String login() {
        return "redirect:/challenge/list";
    }

    @GetMapping("/admin/logout")
    public String logout() {
        return "redirect:/admin";
    }

    //챌린지 관련
    @GetMapping("/challenge/save-form")
    public String challengeSaveForm() {
        return "/challenge/save-form";
    }

    @GetMapping("/challenge/list")
    public String challengeForm() {
        return "challenge/list";
    }

    @GetMapping("/challenge/update-form")
    public String challengeUpdateForm() {
        return "/challenge/update-form";
    }

    //식단 관련
    @GetMapping("/food/save-form")
    public String foodSaveForm() {
        return "food/save-form";
    }

    @GetMapping("/food/update-form")
    public String foodUpdateForm() {
        return "food/update-form";
    }

    @GetMapping("/food/form")
    public String foodForm() {
        return "food/list";
    }
}
