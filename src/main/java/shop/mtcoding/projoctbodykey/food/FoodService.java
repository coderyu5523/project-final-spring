package shop.mtcoding.projoctbodykey.food;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.challenge.Challenge;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {
    private final FoodJPARepository foodJPARepository ;

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
}
