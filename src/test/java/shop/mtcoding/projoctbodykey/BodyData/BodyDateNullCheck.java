package shop.mtcoding.projoctbodykey.BodyData;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class BodyDateNullCheck {

    @Test
    public void nullCheck_Test() {
        Double bodyData = null;

        Double a = Optional.ofNullable(bodyData).orElse(null);

        System.out.println(a);
    }
}
