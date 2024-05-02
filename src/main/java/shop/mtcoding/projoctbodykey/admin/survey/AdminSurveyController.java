package shop.mtcoding.projoctbodykey.admin.survey;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey.food.FoodRequest;
import shop.mtcoding.projoctbodykey.food.FoodResponse;
import shop.mtcoding.projoctbodykey.food.FoodService;
import shop.mtcoding.projoctbodykey.survey.SurveyResponse;
import shop.mtcoding.projoctbodykey.survey.SurveyService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminSurveyController {

    private final SurveyService surveyService;

    //식단 관련
    @GetMapping("/admin/surveys/save-form")
    public String surveySaveForm() {
        return "survey/save-form";
    }

    @PostMapping("/admin/surveys/save")
    public String surveySave(@RequestBody List<AdminSurveyRequest.SaveDTO> reqDTOs) {
        System.out.println("reqDTOs = " + reqDTOs);
        return "redirect:/admin/surveys";
    }


    @GetMapping("/admin/surveys/{id}/update-form")
    public String surveyUpdateForm(@PathVariable int id, HttpServletRequest request) {
//        FoodResponse.FoodDTO respDTO = surveyService.findById(id);
//        request.setAttribute("food", respDTO);
        return "survey/update-form";
    }

    @PostMapping("/admin/surveys/{id}/update")
    public String surveyUpdate(@PathVariable int id, FoodRequest.UpdateDTO reqDTO) {
//        FoodResponse.UpdateDTO respDTO=surveyService.update(id, reqDTO);
        return "redirect:/admin/surveys";
    }

    @GetMapping("/admin/surveys/{id}")
    public String surveyDetail(HttpServletRequest request) {
//        List<FoodResponse.FoodsDTO> respDTO = surveyService.findAll();
//        request.setAttribute("foods", respDTO);
        return "surveys";
    }

    @GetMapping("/admin/surveys")
    public String surveys(HttpServletRequest request) {
        List<SurveyResponse.SurveysDTO> respDTO = surveyService.findAll();
        request.setAttribute("surveys", respDTO);
        return "survey/survey";
    }

    @PostMapping("/admin/surveys/{id}/delete")
    public String surveyDelete(@PathVariable int id) {
//        surveyService.delete(id);
        return "redirect:/admin/surveys";
    }
}
