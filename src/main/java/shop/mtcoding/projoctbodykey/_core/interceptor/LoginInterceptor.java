package shop.mtcoding.projoctbodykey._core.interceptor;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception401;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception500;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey.activity.ActivityService;
import shop.mtcoding.projoctbodykey.user.SessionUser;


@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final ActivityService activityService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("preHandle............");

//        String requestURI = request.getRequestURI();
//        if ("/login".equals(requestURI)) {
//            SessionUser sessionUser = new SessionUser("ssar");
//            activityService.save(sessionUser);
//            return true;
//        }

        // Bearer jwt 토큰 으로 들어오는 것이 프로토콜이다.
        String jwt = request.getHeader("Authorization");

        // 검증
        try {
            jwt = jwt.replace("Bearer ", "");
            SessionUser sessionUser = JwtUtil.verify(jwt);
            HttpSession session = request.getSession();
            session.setAttribute("sessionUser", sessionUser);
            return true;
        } catch (TokenExpiredException e) {
            throw new Exception401("토큰 만료시간이 지났어요. 다시 로그인하세요");
        } catch (JWTDecodeException e) {
            throw new Exception401("토큰이 유효하지 않습니다");
        } catch (NullPointerException e) {
            throw new Exception404("로그인 해주세요");
        } catch (Exception e) {
            e.printStackTrace(); // 개발 진행 시 TEST 보기
            throw new Exception500(e.getMessage()); // 알 수 없는 오류 이니깐 500으로 다 던져 준다.
        }
    }
}