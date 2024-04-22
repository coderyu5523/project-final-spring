package shop.mtcoding.projoctbodykey.body;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BodyQueryRepository {
    private final EntityManager em;
}
