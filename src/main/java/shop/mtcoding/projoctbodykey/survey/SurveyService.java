package shop.mtcoding.projoctbodykey.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswerJPARepository;
import shop.mtcoding.projoctbodykey.food.Food;
import shop.mtcoding.projoctbodykey.food.FoodResponse;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoice;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoiceJPARepository;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoiceRequest;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestionJPARepository;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestionRequest;

import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SurveyService {
    private final SurveyJPARepository surveyJPARepository ;
    private final SurveyQuestionJPARepository surveyQuestionJPARepository ;
    private final QuestionChoiceJPARepository questionChoiceJPARepository;


    public void save(AdminSurveyRequest.SaveDTO reqDTOs) {
        //설문지 제목 저장
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SurveyRequest.SaveDTO saveSurveyDTO= new SurveyRequest.SaveDTO(reqDTOs.getSurveyName(),timestamp);
        Survey survey=surveyJPARepository.save(saveSurveyDTO.toEntity());
        System.out.println("survey = " + survey);

        //설문지 질문 저장
        for (int i=0; i<reqDTOs.getQuestionElements().size();i++){
            String question=reqDTOs.getQuestionElements().get(i).getQuestion();
            SurveyQuestionRequest.SaveDTO saveQuestionDTO= new SurveyQuestionRequest.SaveDTO(survey,question,timestamp);
            SurveyQuestion surveyQuestion=surveyQuestionJPARepository.save(saveQuestionDTO.toEntity());

            //설문지 질문 선택 항목 저장
            for (int j=0; j<reqDTOs.getQuestionElements().get(i).getChoices().size();j++){
                String choice=reqDTOs.getQuestionElements().get(i).getChoices().get(j);
                QuestionChoiceRequest.SaveDTO saveChoiceDTO= new QuestionChoiceRequest.SaveDTO(survey,surveyQuestion, choice, timestamp);
                QuestionChoice questionChoice=questionChoiceJPARepository.save(saveChoiceDTO.toEntity());
            }
        }
    }

    public List<SurveyResponse.SurveysDTO> findAll() {
        List<Survey> surveys = surveyJPARepository.findAll();
        return surveys.stream().map(SurveyResponse.SurveysDTO::new).toList();
    }
}
