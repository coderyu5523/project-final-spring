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
import shop.mtcoding.projoctbodykey.challenge.ChallengeResponse;
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


        // 내림차순 정렬
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        // 페이징 하기위해 사용함
        // sort를 Pageable에 넣어주면 내림차순 가능
        Pageable pageable = PageRequest.of(page, size, sort);

        // 키워드에 값이 없으면
        if (keyword.isBlank()) {

            ChallengeResponse.AdminChallengeListDTO challengeList =
                    challengeService.adminChallengeList(page, pageable);
            request.setAttribute("challenges", challengeList);

            // 키워드에 값이 있으면
        } else {

            ChallengeResponse.AdminChallengeSearchListDTO challengeSearchList =
                    challengeService.adminChallengeSearchList(keyword, page, pageable);
            request.setAttribute("challengeSearchList", challengeSearchList);
        }

        return "/challenge/challenges";
    }


    @GetMapping("/admin/challenges/{id}/detail")
    public String challengeDetail(@PathVariable("id") Integer id, HttpServletRequest request) {
        Challenge challenge = challengeService.adminDetail(id);
        request.setAttribute("challenge", challenge);
        return "/challenge/detail";
    }

    @GetMapping("/admin/challenges/{id}/update-form")
    public String challengeUpdateForm(@PathVariable("id") Integer id, HttpServletRequest request) {
        Challenge challenge = challengeService.adminUpdateForm(id);
        request.setAttribute("challenge", challenge);
        return "/challenge/update-form";
    }

    @PostMapping("/admin/challenges/save")
    public String challengeSave(ChallengeRequest.AdminSaveDTO reqDTO, String period) {
        challengeService.adminSave(reqDTO, period);

        return "redirect:/admin/challenges";
    }


    @PostMapping("/admin/challenges/{id}/update")
    public String challengeUpdate(@PathVariable Integer id, ChallengeRequest.AdminUpdateDTO reqDTO) {
        challengeService.adminUpdate(id, reqDTO);

        return "redirect:/admin/challenges";
    }

    @PostMapping("/admin/challenges/{id}/delete")
    public String challengeDelete(@PathVariable("id") Integer id) {
        challengeService.adminDelete(id);
        return "redirect:/admin/challenges";
    }
}
