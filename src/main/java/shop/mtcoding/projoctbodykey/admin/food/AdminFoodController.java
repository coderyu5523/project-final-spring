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
import shop.mtcoding.projoctbodykey.challenge.ChallengeResponse;
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

        // 내림차순 정렬
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        // 페이징 하기위해 사용함
        // sort를 Pageable에 넣어주면 내림차순 가능
        Pageable pageable = PageRequest.of(page, size, sort);

        // 키워드에 값이 없으면
        if (keyword.isBlank()) {

            FoodResponse.AdminFoodListDTO foods = foodService.adminFoodList(page, pageable);
            request.setAttribute("foods", foods);

        // 키워드에 값이 있으면
        } else {

            FoodResponse.AdminFoodSearchListDTO foodSearchList = foodService.adminFoodSearchList(keyword, page, pageable);
            request.setAttribute("foodSearchList", foodSearchList);
        }

        return "food/foods";
    }

    @PostMapping("/admin/foods/{id}/delete")
    public String foodDelete(@PathVariable int id) {
        foodService.delete(id);
        return "redirect:/admin/foods";
    }
}
