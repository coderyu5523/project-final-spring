package shop.mtcoding.projoctbodykey.admin.challenge;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.projoctbodykey.AttendChallenge.AttendChallengeService;
import shop.mtcoding.projoctbodykey.Challenge.Challenge;
import shop.mtcoding.projoctbodykey.Challenge.ChallengeRequest;
import shop.mtcoding.projoctbodykey.Challenge.ChallengeService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminChallengeController {
    private final ChallengeService challengeService;
    private final AttendChallengeService attendChallengeService;

    //챌린지 관련
    @GetMapping("/admin/challenge/save-form")
    public String challengeSaveForm() {
        return "/challenge/save-form";
    }

    @GetMapping("/admin/challenge/list")
    public String challengeForm(HttpServletRequest request) {
        List<Challenge> ChallengeList = challengeService.adminChallengeList();

        request.setAttribute("ChallengeList", ChallengeList);

        return "challenge/list";
    }

    @GetMapping("/admin/challenge/detail")
    public String challengeDetail() {
        return "/challenge/detail";
    }

    @GetMapping("/admin/challenge/update-form")
    public String challengeUpdateForm() {
        return "/challenge/update-form";
    }

    @PostMapping("/admin/challenge/save")
    public String challengeSave(ChallengeRequest.AdminChallengeSaveDTO reqDTO) throws IOException {

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
}
