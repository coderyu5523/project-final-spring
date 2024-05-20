package shop.mtcoding.projoctbodykey.dosurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;

import java.util.List;
import java.util.Optional;

public interface DoSurveyJPARepository extends JpaRepository<DoSurvey, Integer> {
    @Query("select ds from DoSurvey ds where ds.user.id = :userId and ds.survey.id = :surveyId")
    Optional<DoSurvey> findByUserIdAndSurveyId(@Param("userId") Integer userId, @Param("surveyId") Integer surveyId);

    @Query("SELECT new shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest$UserStatsDTO(dss.id, dss.title, COUNT(distinct ds.user.id)) FROM DoSurvey ds join ds.survey dss GROUP BY dss.id, dss.title")
    List<AdminSurveyRequest.UserStatsDTO> findWithChoiceCount();
}
