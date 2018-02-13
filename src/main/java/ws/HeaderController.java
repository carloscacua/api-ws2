package ws;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/header")
public class HeaderController {

    @ApiOperation(value = "Check header endpoint")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String checkHeader() {
        return "Success";
    }
}

