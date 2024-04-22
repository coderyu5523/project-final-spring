package shop.mtcoding.projoctbodykey.body;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BodyService {
    private final BodyJPARepository bodyJPARepository;
}
