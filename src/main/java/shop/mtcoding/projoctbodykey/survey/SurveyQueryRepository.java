package shop.mtcoding.projoctbodykey.survey;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SurveyQueryRepository {
    private final EntityManager em;
}
