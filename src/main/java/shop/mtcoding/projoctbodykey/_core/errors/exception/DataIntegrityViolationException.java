package shop.mtcoding.projoctbodykey._core.errors.exception;

public class DataIntegrityViolationException extends org.springframework.dao.DataIntegrityViolationException {

    public DataIntegrityViolationException(String msg) {
        super(msg);
    }
}
