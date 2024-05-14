package shop.mtcoding.projoctbodykey.choiceanswer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataRequest;
import shop.mtcoding.projoctbodykey.dosurvey.DoSurvey;
import shop.mtcoding.projoctbodykey.dosurvey.DoSurveyJPARepository;
import shop.mtcoding.projoctbodykey.dosurvey.DoSurveyRequest;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoice;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoiceJPARepository;
import shop.mtcoding.projoctbodykey.survey.Survey;
import shop.mtcoding.projoctbodykey.survey.SurveyJPARepository;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestionJPARepository;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChoiceAnswerService {
    private final UserJPARepository userJPARepository;
    private final SurveyJPARepository surveyJPARepository;
    private final SurveyQuestionJPARepository surveyQuestionJPARepository;
    private final QuestionChoiceJPARepository questionChoiceJPARepository;
    private final ChoiceAnswerJPARepository choiceAnswerJPARepository ;
    private final DoSurveyJPARepository doSurveyJPARepository;

    public ChoiceAnswerResponse.GetChoiceAnswer save(Integer userId, Integer surveyId, List<ChoiceAnswerRequest.AnswerDTO> answers) {
        //유저와 설문조사 찾기
        User user=userJPARepository.findById(userId).orElseThrow(() -> new Exception404("유저가 없습니다"));
        Survey survey = surveyJPARepository.findById(surveyId).orElseThrow(() -> new Exception404("설문조사가 없습니다"));

        //대답받은 설문내용 저장
        List<ChoiceAnswer> choiceAnswers = new ArrayList<>();
        for (ChoiceAnswerRequest.AnswerDTO answer : answers) {
            SurveyQuestion surveyQuestion = surveyQuestionJPARepository.findById(answer.getQuestionId()).orElseThrow(() -> new Exception404("질문이 없습니다"));
            QuestionChoice questionChoice = questionChoiceJPARepository.findById(answer.getChoiceId()).orElseThrow(() -> new Exception404("선택문항이 없습니다"));
            ChoiceAnswerRequest.SaveDTO saveDTO = new ChoiceAnswerRequest.SaveDTO(user, survey, surveyQuestion, questionChoice);
            choiceAnswers.add(saveDTO.toEntity());
        }
        List<ChoiceAnswer> choiceAnswerList=choiceAnswerJPARepository.saveAll(choiceAnswers);

        //설문조사 완료 처리
        DoSurveyRequest.SaveDTO doSurveySave=new DoSurveyRequest.SaveDTO(user, survey);
        doSurveyJPARepository.save(doSurveySave.toEntity());


        return new ChoiceAnswerResponse.GetChoiceAnswer(user.getId(),survey.getId(),choiceAnswerList.stream()
                .map(choiceAnswer -> new ChoiceAnswerResponse.GetChoiceAnswer
                        .QuestionAndAnswerDTO(choiceAnswer.getSurveyQuestion().getId(),choiceAnswer.getQuestionChoice().getId())).toList());
    }
}
