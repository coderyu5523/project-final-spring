package shop.mtcoding.projoctbodykey.questionchoice;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;

public interface QuestionChoiceJPARepository extends JpaRepository<QuestionChoice, Integer> {
}
