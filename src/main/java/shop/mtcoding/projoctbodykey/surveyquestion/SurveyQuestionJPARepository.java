package shop.mtcoding.projoctbodykey.surveyquestion;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.projoctbodykey.survey.Survey;

public interface SurveyQuestionJPARepository extends JpaRepository<SurveyQuestion, Integer> {
}
