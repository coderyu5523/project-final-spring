package shop.mtcoding.projoctbodykey.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswer;

public interface SurveyJPARepository extends JpaRepository<Survey, Integer> {
}
