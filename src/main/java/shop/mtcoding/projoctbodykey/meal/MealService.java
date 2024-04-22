package shop.mtcoding.projoctbodykey.meal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MealService {
    private final MealJPARepository mealJPARepository ;
}
