package shop.mtcoding.projoctbodykey.surveyquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.survey.Survey;

import java.util.List;
import java.util.Optional;

public interface SurveyQuestionJPARepository extends JpaRepository<SurveyQuestion, Integer> {

    @Query("select sq from SurveyQuestion sq where sq.survey.id = :surveyId")
    List<SurveyQuestion> findBySurveyId(@Param("surveyId") Integer surveyId);
}
