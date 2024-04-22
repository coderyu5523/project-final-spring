package shop.mtcoding.projoctbodykey.food;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService foodService;
    private final HttpSession session;


}
