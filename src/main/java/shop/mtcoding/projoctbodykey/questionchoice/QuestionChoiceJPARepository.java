package shop.mtcoding.projoctbodykey.questionchoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;

import java.util.List;
import java.util.Optional;

public interface QuestionChoiceJPARepository extends JpaRepository<QuestionChoice, Integer> {
    @Query("select qc from QuestionChoice qc where qc.survey.id = :surveyId and qc.surveyQuestion.id= :surveyQuestionId")
    List<QuestionChoice> findBySurveyIdAndQuestionId(@Param("surveyId") Integer surveyId, @Param("surveyQuestionId") Integer surveyQuestionId);

    @Modifying
    @Query("delete from QuestionChoice qc where qc.survey.id = :surveyId")
    void deleteBySurveyId(@Param("surveyId") Integer surveyId);
}
