package shop.mtcoding.projoctbodykey.dosurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;

import java.util.List;
import java.util.Optional;

public interface DoSurveyJPARepository extends JpaRepository<DoSurvey, Integer> {
    @Query("select ds from DoSurvey ds where ds.user.id = :userId and ds.survey.id = :surveyId")
    Optional<DoSurvey> findByUserIdAndSurveyId(@Param("userId") Integer userId, @Param("surveyId") Integer surveyId);
}
