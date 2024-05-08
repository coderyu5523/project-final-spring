package shop.mtcoding.projoctbodykey.choiceanswer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest;

import java.util.List;

public interface ChoiceAnswerJPARepository extends JpaRepository<ChoiceAnswer, Integer> {

    @Query("select new shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest$ChoiceCountDTO(ca.questionChoice.id, COUNT(ca.questionChoice.id)) FROM ChoiceAnswer ca WHERE ca.surveyQuestion.id = :questionId GROUP BY ca.questionChoice.id")
    List<AdminSurveyRequest.ChoiceCountDTO> findWithChoiceCount(@Param("questionId") Integer surveyId);

    @Query("SELECT new shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest$UserStatsDTO(s.id, s.title, COUNT(DISTINCT ca.user.id)) FROM ChoiceAnswer ca right JOIN  ca.survey s GROUP BY s.id")
    List<AdminSurveyRequest.UserStatsDTO> findWithChoiceCount();

}
