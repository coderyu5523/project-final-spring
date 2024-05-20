package shop.mtcoding.projoctbodykey.survey;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyResponse;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswerJPARepository;
import shop.mtcoding.projoctbodykey.dosurvey.DoSurvey;
import shop.mtcoding.projoctbodykey.dosurvey.DoSurveyJPARepository;
import shop.mtcoding.projoctbodykey.food.Food;
import shop.mtcoding.projoctbodykey.food.FoodResponse;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoice;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoiceJPARepository;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoiceRequest;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestionJPARepository;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestionRequest;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SurveyService {
    private final SurveyJPARepository surveyJPARepository;
    private final SurveyQuestionJPARepository surveyQuestionJPARepository;
    private final QuestionChoiceJPARepository questionChoiceJPARepository;
    private final ChoiceAnswerJPARepository choiceAnswerJPARepository;
    private final DoSurveyJPARepository doSurveyJPARepository;

    public List<SurveyResponse.SurveyDTO> surveyList(Integer userId){
        List<AdminSurveyRequest.SurveyAndQuestionCount> surveys = surveyJPARepository.findWithQuestionCountAndAgress();
        List<SurveyResponse.SurveyDTO> surveysSatus = new ArrayList<>();

        for (AdminSurveyRequest.SurveyAndQuestionCount survey : surveys){
            DoSurvey doSurvey = doSurveyJPARepository.findByUserIdAndSurveyId(userId, survey.getSurvey().getId()).orElse(null);
            SurveyResponse.SurveyDTO surveysDTO = new SurveyResponse.SurveyDTO(survey, doSurvey);
            surveysSatus.add(surveysDTO);
        }
        return surveysSatus;
    }

    public AdminSurveyResponse.ChartDTO chart(int id) {
        Survey survey = surveyJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 설문조사를 찾을 수 없습니다"));
        List<SurveyQuestion> questions = surveyQuestionJPARepository.findBySurveyId(survey.getId());

        List<AdminSurveyResponse.ChartDTO.QuestionDTO> questionElements = new ArrayList<>();

        for (SurveyQuestion question : questions) {
            List<QuestionChoice> questionChoices =
                    questionChoiceJPARepository.findBySurveyIdAndQuestionId(survey.getId(), question.getId()).stream().toList();
            List<AdminSurveyRequest.ChoiceCountDTO> choiceCount = choiceAnswerJPARepository.findWithChoiceCount(question.getId());

            AdminSurveyResponse.ChartDTO.QuestionDTO questionElement =
                    new AdminSurveyResponse.ChartDTO.QuestionDTO(
                            question,
                            questionChoices.stream().map(QuestionChoice::getChoiceItem).toList(),
                            questionChoices.stream().map(QuestionChoice::getChoiceNumber).toList(),
                            choiceCount.stream().map(AdminSurveyRequest.ChoiceCountDTO::getChoiceCount).toList()
                    );

            questionElements.add(questionElement);
        }
        AdminSurveyResponse.ChartDTO chartDTO = new AdminSurveyResponse.ChartDTO(survey.getId(), survey.getTitle(), questionElements);

        return chartDTO;
    }

    @Transactional
    public void save(AdminSurveyRequest.SaveDTO reqDTOs) {
        //설문지 제목 저장
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SurveyRequest.SaveDTO saveSurveyDTO = new SurveyRequest.SaveDTO(reqDTOs.getTitle(), timestamp);
        Survey survey = surveyJPARepository.save(saveSurveyDTO.toEntity());

        //설문지 질문 저장
        for (int i = 0; i < reqDTOs.getQuestionElements().size(); i++) {
            String question = reqDTOs.getQuestionElements().get(i).getQuestion();
            SurveyQuestionRequest.SaveDTO saveQuestionDTO = new SurveyQuestionRequest.SaveDTO(survey, question, timestamp);
            SurveyQuestion surveyQuestion = surveyQuestionJPARepository.save(saveQuestionDTO.toEntity());
            //설문지 질문 선택 항목 저장
            for (int j = 0; j < reqDTOs.getQuestionElements().get(i).getChoices().size(); j++) {
                String choice = reqDTOs.getQuestionElements().get(i).getChoices().get(j);
                QuestionChoiceRequest.SaveDTO saveChoiceDTO = new QuestionChoiceRequest.SaveDTO(survey, j + 1, surveyQuestion, choice, timestamp);
                QuestionChoice questionChoice = questionChoiceJPARepository.save(saveChoiceDTO.toEntity());
            }
        }
    }

    @Transactional
    public void update(int id, AdminSurveyRequest.UpdateDTO reqDTOs) {
        //설문지 제목 저장
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Survey survey = surveyJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 설문조사를 찾을 수 없습니다"));
        survey.update(reqDTOs.getTitle(), reqDTOs.getStatus(),timestamp);

        questionChoiceJPARepository.deleteBySurveyId(survey.getId());
        surveyQuestionJPARepository.deleteBySurveyId(survey.getId());

        //설문지 질문 저장
        for (int i = 0; i < reqDTOs.getQuestionElements().size(); i++) {
            String question = reqDTOs.getQuestionElements().get(i).getQuestion();
            SurveyQuestionRequest.SaveDTO saveQuestionDTO = new SurveyQuestionRequest.SaveDTO(survey, question, timestamp);
            SurveyQuestion surveyQuestion = surveyQuestionJPARepository.save(saveQuestionDTO.toEntity());

            //설문지 질문 선택 항목 저장
            for (int j = 0; j < reqDTOs.getQuestionElements().get(i).getChoices().size(); j++) {
                String choice = reqDTOs.getQuestionElements().get(i).getChoices().get(j);
                QuestionChoiceRequest.SaveDTO saveChoiceDTO = new QuestionChoiceRequest.SaveDTO(survey, j + 1, surveyQuestion, choice, timestamp);
                QuestionChoice questionChoice = questionChoiceJPARepository.save(saveChoiceDTO.toEntity());
            }
        }
    }


    public List<AdminSurveyResponse.SurveysDTO> findWithQuestionCount() {
        List<AdminSurveyRequest.SurveyAndQuestionCount> surveys = surveyJPARepository.findWithQuestionCount();
        return surveys.stream().map(AdminSurveyResponse.SurveysDTO::new).toList();
    }

    public AdminSurveyResponse.statsDTO chartList() {
        List<AdminSurveyRequest.SurveyAndQuestionCount> surveys = surveyJPARepository.findWithQuestionCount();
        List<AdminSurveyRequest.UserStatsDTO> userStats=doSurveyJPARepository.findWithChoiceCount();
        AdminSurveyResponse.statsDTO stats=new AdminSurveyResponse.statsDTO(
                surveys.stream().map(AdminSurveyResponse.statsDTO.SurveysDTO::new).toList(),
                userStats.stream().map(AdminSurveyResponse.statsDTO.ChartDTO::new).toList());
        return stats;
    }
    public AdminSurveyResponse.DetailStatusDTO findByIdWithStatus(int id) {
        Survey survey = surveyJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 설문조사를 찾을 수 없습니다"));
        List<SurveyQuestion> surveyQuestion = surveyQuestionJPARepository.findBySurveyId(survey.getId());

        List<AdminSurveyResponse.DetailStatusDTO.QuestionDTO> questionElements = new ArrayList<>();
        for (SurveyQuestion question : surveyQuestion) {
            List<QuestionChoice> questionChoices =
                    questionChoiceJPARepository.findBySurveyIdAndQuestionId(survey.getId(), question.getId()).stream().toList();

            AdminSurveyResponse.DetailStatusDTO.QuestionDTO questionElement =
                    new AdminSurveyResponse.DetailStatusDTO.QuestionDTO(
                            question,
                            questionChoices.stream().map(QuestionChoice::getId).toList(),
                            questionChoices.stream().map(QuestionChoice::getChoiceItem).toList(),
                            questionChoices.stream().map(QuestionChoice::getChoiceNumber).toList()
                    );

            questionElements.add(questionElement);
        }

        AdminSurveyResponse.DetailStatusDTO detailDTO = new AdminSurveyResponse.DetailStatusDTO(survey, questionElements);

        return detailDTO;
    }

    public AdminSurveyResponse.DetailDTO findById(int id) {
        Survey survey = surveyJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 설문조사를 찾을 수 없습니다"));
        List<SurveyQuestion> surveyQuestion = surveyQuestionJPARepository.findBySurveyId(survey.getId());

        List<AdminSurveyResponse.DetailDTO.QuestionDTO> questionElements = new ArrayList<>();
        for (SurveyQuestion question : surveyQuestion) {
            List<QuestionChoice> questionChoices =
                    questionChoiceJPARepository.findBySurveyIdAndQuestionId(survey.getId(), question.getId()).stream().toList();

            AdminSurveyResponse.DetailDTO.QuestionDTO questionElement =
                    new AdminSurveyResponse.DetailDTO.QuestionDTO(
                            question,
                            questionChoices.stream().map(QuestionChoice::getId).toList(),
                            questionChoices.stream().map(QuestionChoice::getChoiceItem).toList(),
                            questionChoices.stream().map(QuestionChoice::getChoiceNumber).toList()
                    );

            questionElements.add(questionElement);
        }

        AdminSurveyResponse.DetailDTO detailDTO = new AdminSurveyResponse.DetailDTO(survey, questionElements);

        return detailDTO;
    }

    public SurveyResponse.DetailDTO findByIdApp(int id) {
        Survey survey = surveyJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 설문조사를 찾을 수 없습니다"));
        List<SurveyQuestion> surveyQuestion = surveyQuestionJPARepository.findBySurveyId(survey.getId());

        List<SurveyResponse.DetailDTO.QuestionDTO> questionElements = new ArrayList<>();
        for (SurveyQuestion question : surveyQuestion) {
            List<QuestionChoice> questionChoices =
                    questionChoiceJPARepository.findBySurveyIdAndQuestionId(survey.getId(), question.getId()).stream().toList();

            SurveyResponse.DetailDTO.QuestionDTO questionElement =
                    new SurveyResponse.DetailDTO.QuestionDTO(
                            question,
                            questionChoices.stream().map(QuestionChoice::getId).toList(),
                            questionChoices.stream().map(QuestionChoice::getChoiceItem).toList(),
                            questionChoices.stream().map(QuestionChoice::getChoiceNumber).toList()
                    );

            questionElements.add(questionElement);
        }

        SurveyResponse.DetailDTO detailDTO = new SurveyResponse.DetailDTO(survey, questionElements);

        return detailDTO;
    }

    @Transactional
    public void delete(int id) {
        Survey survey = surveyJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 설문조사를 찾을 수 없습니다"));

        questionChoiceJPARepository.deleteBySurveyId(survey.getId());
        surveyQuestionJPARepository.deleteBySurveyId(survey.getId());
        surveyJPARepository.deleteById(survey.getId());

    }

    @Transactional
    public void statusUpdate(int id, String status) {
        Survey survey = surveyJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 설문조사를 찾을 수 없습니다"));
        survey.statusUpdate(status);

    }
}
