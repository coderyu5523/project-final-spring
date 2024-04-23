package shop.mtcoding.projoctbodykey.bodydata;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BodydataService {
    private final BodydataJPARepository bodydataJPARepository;
}
