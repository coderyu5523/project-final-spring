package shop.mtcoding.projoctbodykey.admin.food;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.food.Food;
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
    public String foods(HttpServletRequest request,
                        @RequestParam(value = "keyword", defaultValue = "") String keyword,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "10") int size) {

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        if (keyword.isBlank()) {

            Page<Food> foods = foodService.adminListPaged(pageable);
            request.setAttribute("foods", foods);
            request.setAttribute("first", page == 0);
            request.setAttribute("last", foods.getTotalPages() == page + 1);
            request.setAttribute("prev", page - 1);
            request.setAttribute("keyword", "");
            request.setAttribute("next", page + 1);
        } else {

            Page<Food> foodSearchList = foodService.foodSearch(keyword, pageable);
            request.setAttribute("foodSearchList", foodSearchList);
            request.setAttribute("first", page == 0);
            request.setAttribute("last", foodSearchList.getTotalPages() == page + 1);
            request.setAttribute("prev", page - 1);
            request.setAttribute("next", page + 1);
            request.setAttribute("keyword", keyword);
        }

        return "food/foods";
    }

    @PostMapping("/admin/foods/{id}/delete")
    public String foodDelete(@PathVariable int id) {
        foodService.delete(id);
        return "redirect:/admin/foods";
    }
}
