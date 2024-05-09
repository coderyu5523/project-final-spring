package shop.mtcoding.projoctbodykey.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswer;
import shop.mtcoding.projoctbodykey.user.User;

import java.util.List;
import java.util.Optional;

public interface SurveyJPARepository extends JpaRepository<Survey, Integer> {

    @Query("SELECT new shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest$SurveyAndQuestionCount(s, COUNT(DISTINCT sq.id)) from Survey s left join SurveyQuestion sq on s.id=sq.survey.id group by s.id")
    List<AdminSurveyRequest.SurveyAndQuestionCount> findWithQuestionCount();

}
