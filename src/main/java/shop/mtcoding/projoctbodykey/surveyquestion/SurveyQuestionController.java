package shop.mtcoding.projoctbodykey.surveyquestion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey.survey.SurveyService;

@RequiredArgsConstructor
@RestController
public class SurveyQuestionController {
    private final SurveyQuestionService SurveyQuestionService;
}
