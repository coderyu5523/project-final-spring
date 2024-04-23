package shop.mtcoding.projoctbodykey.admin;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey.activity.ActivityService;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.challenge.ChallengeService;
import shop.mtcoding.projoctbodykey.food.FoodService;
import shop.mtcoding.projoctbodykey.user.UserService;
import shop.mtcoding.projoctbodykey.whichChallenge.WhichChallenge;
import shop.mtcoding.projoctbodykey.whichChallenge.WhichChallengeRequest;
import shop.mtcoding.projoctbodykey.whichChallenge.WhichChallengeService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminController {

    private final UserService userService;
    private final ActivityService activityService;
    private final ChallengeService challengeService;
    private final WhichChallengeService whichChallengeService;
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
        List<WhichChallenge> whichChallengeList = whichChallengeService.whichChallengeList();

        request.setAttribute("whichChallengeList", whichChallengeList);

        return "challenge/list";
    }

    @GetMapping("/admin/challenge/update-form")
    public String challengeUpdateForm() {
        return "/challenge/update-form";
    }

    @PostMapping("/admin/challenge/save")
    public String challengeSave(WhichChallengeRequest.AdminChallengeSaveDTO reqDTO) {
        whichChallengeService.adminChallengeSave(reqDTO);

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

    @GetMapping("/admin/food/form")
    public String foodForm() {
        return "food/list";
    }
}
