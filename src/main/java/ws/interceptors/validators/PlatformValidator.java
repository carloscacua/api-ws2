package ws.interceptors.validators;

import ws.exceptions.BadRequestException;
import ws.interceptors.IValidator;
import org.springframework.stereotype.Component;


@Component
public class PlatformValidator implements IValidator {
    private String headerName = "Platform";
    private String iOS = "ios";
    private String android = "android";

    public String headerKey() {
        return headerName;
    }

    public void checkHeader(String value)throws Exception  {
        if (value == null || (value.toLowerCase().equals(iOS) && value.toLowerCase().equals(android))) {
            throw new BadRequestException("Platform not supported");
        }
    }
}
