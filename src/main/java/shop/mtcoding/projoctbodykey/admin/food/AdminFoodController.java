package shop.mtcoding.projoctbodykey.admin.food;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.projoctbodykey.food.FoodRequest;
import shop.mtcoding.projoctbodykey.food.FoodResponse;
import shop.mtcoding.projoctbodykey.food.FoodService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminFoodController {

    private final FoodService foodService;

    //식단 관련
    @GetMapping("/admin/food/save-form")
    public String foodSaveForm() {
        return "food/save-form";
    }

    @PostMapping("/admin/food/save")
    public String foodSave(FoodRequest.SaveDTO reqDTO) {
        FoodResponse.SaveDTO respDTO=foodService.save(reqDTO);
        return "redirect:/admin/food/list";
    }

    @GetMapping("/admin/food/{id}/update-form")
    public String foodUpdateForm(@PathVariable int id, HttpServletRequest request) {
        FoodResponse.FoodDTO respDTO = foodService.findById(id);
        request.setAttribute("food", respDTO);
        return "food/update-form";
    }

    @PostMapping("/admin/food/{id}/update")
    public String foodUpdate(@PathVariable int id, FoodRequest.UpdateDTO reqDTO) {
        FoodResponse.UpdateDTO respDTO=foodService.update(id, reqDTO);
        return "redirect:/admin/food/list";
    }

    @GetMapping("/admin/food/list")
    public String foods(HttpServletRequest request) {
        List<FoodResponse.FoodsDTO> respDTO = foodService.findAll();
        request.setAttribute("foods", respDTO);
        return "food/list";
    }

    @PostMapping("/admin/food/{id}/delete")
    public String foodDelete(@PathVariable int id) {
        foodService.delete(id);
        return "redirect:/admin/food/list";
    }
}
