package shop.mtcoding.projoctbodykey.surveyquestion;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SurveyQuestionService {
    private final SurveyQuestionJPARepository surveyQuestionJPARepository ;
}
