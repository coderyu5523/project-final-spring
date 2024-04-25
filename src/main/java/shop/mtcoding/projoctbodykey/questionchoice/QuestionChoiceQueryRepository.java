package shop.mtcoding.projoctbodykey.questionchoice;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class QuestionChoiceQueryRepository {
    private final EntityManager em;
}
