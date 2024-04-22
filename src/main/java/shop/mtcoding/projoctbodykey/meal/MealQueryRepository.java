package shop.mtcoding.projoctbodykey.meal;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MealQueryRepository {
    private final EntityManager em;
}
