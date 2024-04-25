package shop.mtcoding.projoctbodykey.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswerJPARepository;
import shop.mtcoding.projoctbodykey.food.Food;
import shop.mtcoding.projoctbodykey.food.FoodResponse;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SurveyService {
    private final SurveyJPARepository surveyJPARepository ;

    public List<SurveyResponse.SurveysDTO> findAll() {
        List<Survey> surveys = surveyJPARepository.findAll();
        return surveys.stream().map(SurveyResponse.SurveysDTO::new).toList();
    }
}
