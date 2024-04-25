package shop.mtcoding.projoctbodykey.admin.food;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.projoctbodykey.food.FoodRequest;
import shop.mtcoding.projoctbodykey.food.FoodResponse;
import shop.mtcoding.projoctbodykey.food.FoodService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminFoodController {

    private final FoodService foodService;

    //식단 관련
    @GetMapping("/admin/foods/save-form")
    public String foodSaveForm() {
        return "food/save-form";
    }

    @PostMapping("/admin/foods/save")
    public String foodSave(FoodRequest.SaveDTO reqDTO) {
        FoodResponse.SaveDTO respDTO=foodService.save(reqDTO);
        return "redirect:/admin/foods";
    }

    @GetMapping("/admin/foods/{id}/update-form")
    public String foodUpdateForm(@PathVariable int id, HttpServletRequest request) {
        FoodResponse.FoodDTO respDTO = foodService.findById(id);
        request.setAttribute("food", respDTO);
        return "food/update-form";
    }

    @PostMapping("/admin/foods/{id}/update")
    public String foodUpdate(@PathVariable int id, FoodRequest.UpdateDTO reqDTO) {
        FoodResponse.UpdateDTO respDTO=foodService.update(id, reqDTO);
        return "redirect:/admin/foods";
    }

    @GetMapping("/admin/foods")
    public String foods(HttpServletRequest request) {
        List<FoodResponse.FoodsDTO> respDTO = foodService.findAll();
        request.setAttribute("foods", respDTO);
        return "list";
    }

    @PostMapping("/admin/foods/{id}/delete")
    public String foodDelete(@PathVariable int id) {
        foodService.delete(id);
        return "redirect:/admin/foods";
    }
}
