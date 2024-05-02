package shop.mtcoding.projoctbodykey.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswer;
import shop.mtcoding.projoctbodykey.user.User;

import java.util.Optional;

public interface SurveyJPARepository extends JpaRepository<Survey, Integer> {



}
