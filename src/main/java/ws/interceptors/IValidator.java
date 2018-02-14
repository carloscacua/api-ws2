package ws.interceptors;

import org.springframework.stereotype.Component;

@Component
public interface IValidator {
    String headerKey();
    void checkHeader(String value) throws Exception;
}
