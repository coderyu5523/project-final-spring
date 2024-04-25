package shop.mtcoding.projoctbodykey.choiceanswer;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ChoiceAnswerQueryRepository {
    private final EntityManager em;
}
