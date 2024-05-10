package shop.mtcoding.projoctbodykey.food;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodJPARepository foodJPARepository ;

    // 검색 없는 관리자 페이지 푸드 리스트
    public FoodResponse.AdminFoodListDTO adminFoodList(Integer page, Pageable pageable) {
        Page<Food> foods = foodJPARepository.findAll(pageable);

        // 페이지가 0이라면 첫번째 페이지
        Boolean first = page == 0;

        // 페이지의 토탈 페이지 수가 페이지 수에 1을 더한 값과 같다면 마지막 페이지
        Boolean last = foods.getTotalPages() == page + 1;
        Integer prev = page - 1;
        Integer next = page + 1;

        return new FoodResponse.AdminFoodListDTO(first, last, prev, next, foods);
    }

    // 검색 있는 관리자 페이지 푸드 리스트
    public FoodResponse.AdminFoodSearchListDTO adminFoodSearchList(String keyword, Integer page, Pageable pageable) {
        Page<Food> foods = foodJPARepository.findAllKeyword(keyword, pageable);

        // 페이지가 0이라면 첫번째 페이지
        Boolean first = page == 0;

        // 페이지의 토탈 페이지 수가 페이지 수에 1을 더한 값과 같다면 마지막 페이지
        Boolean last = foods.getTotalPages() == page + 1;
        Integer prev = page - 1;
        Integer next = page + 1;

        return new FoodResponse.AdminFoodSearchListDTO(first, last, prev, next, keyword, foods);
    }

    public Page<Food> adminListPaged(Pageable pageable) {
        return foodJPARepository.findAll(pageable);
    }

    public Page<Food> foodSearch(String keyword, Pageable pageable) {

        Page<Food> foodList = foodJPARepository.findAllKeyword(keyword, pageable);;

        return foodList;
    }

    @Transactional
    public FoodResponse.SaveDTO save(FoodRequest.SaveDTO reqDTO) {
        Food food = foodJPARepository.save(reqDTO.toEntity());
        return new FoodResponse.SaveDTO(food);
    }
    @Transactional
    public FoodResponse.UpdateDTO update(int id, FoodRequest.UpdateDTO reqDTO) {
        Food food = foodJPARepository.findById(id).orElseThrow(() -> new Exception404("찾는 음식이 없습니다"));
        food.update(reqDTO);
        return new FoodResponse.UpdateDTO(food);
    }

    public FoodResponse.FoodDTO findById(int foodId) {
        Food food = foodJPARepository.findById(foodId).orElseThrow(() -> new Exception404("찾는 음식이 없습니다"));
        return new FoodResponse.FoodDTO(food);
    }

    public List<FoodResponse.FoodsDTO> findAll() {
        List<Food> foods = foodJPARepository.findAll();
        return foods.stream().map(FoodResponse.FoodsDTO::new).toList();
    }



    @Transactional
    public void delete(int foodId) {
        Food food = foodJPARepository.findById(foodId).orElseThrow(() -> new Exception404("찾는 음식이 없습니다"));
        foodJPARepository.delete(food);
    }

    public FoodResponse.FoodListDTO foodList(Pageable pageable) {
        Page<Food> foods = foodJPARepository.findAll(pageable);


        return new FoodResponse.FoodListDTO(foods);
    }

    public FoodResponse.FoodSearchListDTO foodSearchList(String keyword, Pageable pageable) {
        Page<Food> foods = foodJPARepository.findAllKeyword(keyword, pageable);


        return new FoodResponse.FoodSearchListDTO(foods);
    }
}
