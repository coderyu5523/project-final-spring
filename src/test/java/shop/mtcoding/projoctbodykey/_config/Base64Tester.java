package shop.mtcoding.projoctbodykey._config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Base64;

public class Base64Tester implements ConstraintValidator<Base64Validator,String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if(value == null || value.isEmpty() ){
            return true;
        }
        try {
            Base64.getDecoder().decode(value);
            return  true;
        }catch (IllegalArgumentException e){
            return false;
        }
    }
}
