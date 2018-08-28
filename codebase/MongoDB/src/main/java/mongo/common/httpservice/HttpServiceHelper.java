package mongo.common.httpservice;

import javax.enterprise.context.control.RequestContextController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServiceHelper {

	public static String handleApiRequest(RequestContextController reqCtxCtrlr, String apiPath, String jsonReqStr,
			HttpServletRequest httpServletReq, HttpServletResponse httpServletRes, HttpRequestHandler httpReqHandler) {

		try {

			activateCdiRequestContext(reqCtxCtrlr);

			String resJsonStr = httpReqHandler.handleRequest(jsonReqStr, httpServletReq, httpServletRes);

			return resJsonStr;

		} catch (RuntimeException e) {
			httpServletRes.setStatus(400);
			return "{\"error_code\":\"Runtime error\",\"error_desc\":\"activating cdi api context\"}";

		} catch (Throwable e) {
			httpServletRes.setStatus(500);
			return "{\"error_code\":\"Throwable\",\"error_desc\":\"activating cdi api context\"}";

		} finally {
			deactivateCdiRequestContext(reqCtxCtrlr);

			System.out.printf("End - Request processed for {%s} ", apiPath);
		}

	}

	private static void activateCdiRequestContext(RequestContextController reqCtxCtrlr) {
		reqCtxCtrlr.activate();
	}

	private static void deactivateCdiRequestContext(RequestContextController reqCtxCtrlr) {
		reqCtxCtrlr.deactivate();
	}

}
