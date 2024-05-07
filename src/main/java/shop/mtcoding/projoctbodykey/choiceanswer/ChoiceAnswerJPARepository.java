package shop.mtcoding.projoctbodykey.choiceanswer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest;

import java.util.List;

public interface ChoiceAnswerJPARepository extends JpaRepository<ChoiceAnswer, Integer> {

    @Query("select new shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest$ChoiceCountDTO(ca.questionChoice.id, COUNT(ca.questionChoice.id)) FROM ChoiceAnswer ca WHERE ca.surveyQuestion.id = :questionId GROUP BY ca.questionChoice.id")
    List<AdminSurveyRequest.ChoiceCountDTO> findWithChoiceCount(@Param("questionId") Integer surveyId);

//    @Query("select new shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest$UserStatsDTO(sub.ca.survey.id, sub.ca.survey.title, sub.count) FROM (SELECT ca.survey.id as surveyId, ca.survey.title as surveyTitle, COUNT(ca.user.id) as count FROM ChoiceAnswer ca GROUP BY ca.survey.id) as sub")
//    List<AdminSurveyRequest.UserStatsDTO> findWithChoiceCount();
}
