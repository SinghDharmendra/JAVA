package mongo.common.httpservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface HttpRequestHandler {
   public String handleRequest(String jsonReqStr, HttpServletRequest httpServletReq,
         HttpServletResponse httpServletRes);
}
