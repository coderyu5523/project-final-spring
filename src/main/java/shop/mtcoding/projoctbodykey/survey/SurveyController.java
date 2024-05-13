package shop.mtcoding.projoctbodykey.survey;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey.activity.ActivityResponse;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswerService;
import shop.mtcoding.projoctbodykey.user.SessionUser;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SurveyController {
    private final SurveyService surveyService;
    private final HttpSession session;


    //설문조사 리스트 폼
    @GetMapping("/api/survey")
    public ResponseEntity<?> surveyList() {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        List<SurveyResponse.SurveyDTO> respDTO = surveyService.surveyList(user.getId());
        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    //설문조사 리스트 폼
    @GetMapping("/api/survey/{id}")
    public ResponseEntity<?> surveyDetail(@PathVariable Integer id) {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        SurveyResponse.DetailDTO respDTO = surveyService.findByIdApp(id);
        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }
}