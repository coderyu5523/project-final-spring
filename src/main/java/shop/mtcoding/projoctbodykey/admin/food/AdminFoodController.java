package shop.mtcoding.projoctbodykey.admin.food;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import shop.mtcoding.projoctbodykey.food.FoodService;

@RequiredArgsConstructor
@Controller
public class AdminFoodController {

    private final FoodService foodService;

    //식단 관련
    @GetMapping("/admin/food/save-form")
    public String foodSaveForm() {
        return "food/save-form";
    }

    @GetMapping("/admin/food/update-form")
    public String foodUpdateForm() {
        return "food/update-form";
    }

    @GetMapping("/admin/food/list")
    public String foodForm() {
        return "food/list";
    }
}
