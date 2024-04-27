package shop.mtcoding.projoctbodykey.admin.challenge;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import shop.mtcoding.projoctbodykey.attendChallenge.AttendChallengeService;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.challenge.ChallengeRequest;
import shop.mtcoding.projoctbodykey.challenge.ChallengeService;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminChallengeController {
    private final ChallengeService challengeService;
    private final AttendChallengeService attendChallengeService;

    //챌린지 관련
    @GetMapping("/admin/challenges/save-form")
    public String challengeSaveForm() {

        return "/challenge/save-form";
    }

    @GetMapping("/admin/challenges")
    public String challengeForm(HttpServletRequest request,
                                @RequestParam(value = "keyword", defaultValue = "") String keyword,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "10") int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        if (keyword.isBlank()) {

            Page<Challenge> challengeList = challengeService.adminListPaged(pageable);
            request.setAttribute("challengeList", challengeList);
            request.setAttribute("first", page == 0);
            request.setAttribute("last", challengeList.getTotalPages() == page + 1);
            request.setAttribute("prev", page - 1);
            request.setAttribute("next", page + 1);
            request.setAttribute("keyword", "");
        } else {

            Page<Challenge> challengeSearchList = challengeService.challengeSearch(keyword, pageable);

            // 전체 페이지 개수
            request.setAttribute("first", page == 0);
            request.setAttribute("last", challengeSearchList.getTotalPages() == page + 1);
            request.setAttribute("prev", page - 1);
            request.setAttribute("next", page + 1);
            request.setAttribute("keyword", keyword);
            request.setAttribute("challengeSearchList", challengeSearchList);
        }

        return "/challenge/challenges";
    }


    @GetMapping("/admin/challenges/detail/{id}")
    public String challengeDetail(@PathVariable("id") Integer id, HttpServletRequest request) {
        Challenge challenge = challengeService.adminDetail(id);
        request.setAttribute("challenge", challenge);
        return "/challenge/detail";
    }

    @GetMapping("/admin/challenges/update-form/{id}")
    public String challengeUpdateForm(@PathVariable("id") Integer id, HttpServletRequest request) {
        Challenge challenge = challengeService.adminUpdateForm(id);
        request.setAttribute("challenge", challenge);
        return "/challenge/update-form";
    }

    @PostMapping("/admin/challenges/save")
    public String challengeSave(ChallengeRequest.AdminSaveDTO reqDTO, String period) throws IOException, ParseException {
        challengeService.adminSave(reqDTO, period);

        return "redirect:/admin/challenges";
    }


    @PostMapping("/admin/challenges/update/{id}")
    public String challengeUpdate(@PathVariable Integer id, ChallengeRequest.AdminUpdateDTO reqDTO, String period) throws IOException, ParseException {
        challengeService.adminUpdate(id, reqDTO, period);

        return "redirect:/admin/challenges";
    }

    @PostMapping("/admin/challenges/delete/{id}")
    public String challengeDelete(@PathVariable("id") Integer id) {
        challengeService.adminDelete(id);
        return "redirect:/admin/challenges";
    }
}
