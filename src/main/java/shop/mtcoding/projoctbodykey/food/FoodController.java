package shop.mtcoding.projoctbodykey.food;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService foodService;
    private final HttpSession session;

    @GetMapping("/api/foods")
    public ResponseEntity<?> foods() {
        FoodResponse.FoodListDTO respDTO = foodService.foodList();

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }
}
