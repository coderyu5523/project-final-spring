package shop.mtcoding.projoctbodykey.bodydata;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BodyDataQueryRepository {
    private final EntityManager em;
}
