package shop.mtcoding.projoctbodykey.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswerJPARepository;

@RequiredArgsConstructor
@Service
public class SurveyService {
    private final SurveyJPARepository surveyJPARepository ;
}
