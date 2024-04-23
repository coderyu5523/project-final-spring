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
    private final AttendChallengeService attendChallengeService;
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
        return "redirect:/admin/challenge/list";
    }

    @GetMapping("/admin/logout")
    public String logout() {
        return "redirect:/admin";
    }


// ====================================================================


    //챌린지 관련
    @GetMapping("/admin/challenge/save-form")
    public String challengeSaveForm() {
        return "/challenge/save-form";
    }

    @GetMapping("/admin/challenge/list")
    public String challengeForm(HttpServletRequest request) {
        List<Challenge> ChallengeList = challengeService.ChallengeList();

        request.setAttribute("ChallengeList", ChallengeList);

        return "challenge/list";
    }

    @GetMapping("/admin/challenge/update-form")
    public String challengeUpdateForm() {
        return "/challenge/update-form";
    }

    @PostMapping("/admin/challenge/save")
    public String challengeSave(ChallengeRequest.AdminChallengeSaveDTO reqDTO) {
        challengeService.adminChallengeSave(reqDTO);

        return "redirect:/admin/challenge/list";
    }

    @PostMapping("/admin/challenge/update")
    public String challengeUpdate() {
        return "redirect:/admin/challenge/list";
    }

    @DeleteMapping("/admin/challenge/delete")
    public String challengeDelete() {
        return "redirect:/admin/challenge/list";
    }


// ====================================================================


    //식단 관련
    @GetMapping("/admin/food/save-form")
    public String foodSaveForm() {
        return "food/save-form";
    }

    @GetMapping("/admin/food/update-form")
    public String foodUpdateForm() {
        return "food/update-form";
    }

    @GetMapping("/admin/food/list")
    public String foodForm() {
        return "food/list";
    }
}
