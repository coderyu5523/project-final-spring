package shop.mtcoding.projoctbodykey.questionchoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestionJPARepository;

@RequiredArgsConstructor
@Service
public class QuestionChoiceService {
    private final QuestionChoiceJPARepository questionChoiceJPARepository ;
}
