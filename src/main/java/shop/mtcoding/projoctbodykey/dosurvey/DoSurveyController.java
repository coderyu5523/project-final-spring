package shop.mtcoding.projoctbodykey.dosurvey;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DoSurveyController {
    private final DoSurveyService doSurveyService;
}
