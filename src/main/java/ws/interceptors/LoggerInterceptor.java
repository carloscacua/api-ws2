package ws.interceptors;

import com.nimbusds.jwt.SignedJWT;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ws.constants.GlobalConstants;
import lombok.extern.slf4j.Slf4j;
import ws.loggers.LoggerInterface;

import java.util.Arrays;


@Service
@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LoggerInterface[] loggers;

    static {
        BasicConfigurator.configure();
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (request.getHeader("Authorization") != null) {
            String accessToken = request.getHeader(GlobalConstants.AUTHORIZATION).replace(GlobalConstants.BEARER, GlobalConstants.EMPTY_STRING);
            String username = SignedJWT.parse(accessToken).getJWTClaimsSet().getCustomClaim(GlobalConstants.USERNAME).toString();
            Arrays.stream(loggers).forEach(l -> l.write("User " + username + " is requesting " + request.getRequestURI()));
        }
        return super.preHandle(request, response, handler);
    }

}