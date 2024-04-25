package shop.mtcoding.projoctbodykey.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswerService;

@RequiredArgsConstructor
@RestController
public class SurveyController {
    private final SurveyService surveyService;
}
