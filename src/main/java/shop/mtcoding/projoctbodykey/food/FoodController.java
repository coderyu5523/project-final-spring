package shop.mtcoding.projoctbodykey.food;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService foodService;
    private final HttpSession session;

    @GetMapping("/api/foods")
    public ResponseEntity<?> foods(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "10") int size) {

        // 페이징 하기위해 사용함
        Pageable pageable = PageRequest.of(page, size);

        // 키워드에 값이 없으면
        if (keyword.isBlank()) {

            FoodResponse.FoodListDTO respDTO = foodService.foodList(pageable);
            return ResponseEntity.ok(new ApiUtil<>(respDTO));

            // 키워드에 값이 있으면
        } else {

            FoodResponse.FoodSearchListDTO respDTO = foodService.foodSearchList(keyword, pageable);
            return ResponseEntity.ok(new ApiUtil<>(respDTO));
        }
    }
}
