package shop.mtcoding.projoctbodykey.surveyquestion;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SurveyQuestionQueryRepository {
    private final EntityManager em;
}
