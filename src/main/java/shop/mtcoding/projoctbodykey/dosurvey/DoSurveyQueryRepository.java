package shop.mtcoding.projoctbodykey.dosurvey;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DoSurveyQueryRepository {
    private final EntityManager em;
}
