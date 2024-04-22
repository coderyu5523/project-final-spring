package shop.mtcoding.projoctbodykey.meal;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MealController {
    private final MealService mealService;
    private final HttpSession session;

    //
}
