package mongo.us.api;

import static mongo.util.JsonUtil.toJson;
import static spark.Spark.after;
import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.post;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.RequestContextController;
import javax.inject.Inject;

import mongo.common.httpservice.HttpRequestHandler;
import mongo.common.httpservice.HttpServiceHelper;
import mongo.entity.ResponseError;
import mongo.handler.UserServiceHandler;
import mongo.util.JsonUtil;
@ApplicationScoped
public class UserHttpService {
	
	private static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
	
	private static final String API_PREFIX = "/user-service/api";
	@Inject
	UserServiceHandler userService;
	
	@Inject
	private RequestContextController reqCtxCtrlr;
	
	   public void registerHttpAPIs() {   
		   
		   System.out.println("Registering HTTP APIs - START");

			registerGetApi(reqCtxCtrlr, buildApiPath("/v1/status"), (jsonReqStr, httpServletReq, httpServletRes) -> {
				return "{\"status\":\"ok\"}";
			});
			
			 registerGetApi(reqCtxCtrlr, buildApiPath("/v1/users"), (jsonReqStr, httpServletReq, httpServletRes) -> {				 
				 return JsonUtil.toJson(userService.getAllUsers());		 
				
		      });
			 
			 registerPostApi(reqCtxCtrlr, buildApiPath("/v1/create-user"),
						(jsonReqStr, httpServletReq, httpServletRes) -> {
							return userService.generateUser(jsonReqStr, httpServletReq, httpServletRes);						
						});
			 after((req, res) -> {
					res.type("application/json");
				});

				exception(IllegalArgumentException.class, (e, req, res) -> {
					res.status(400);
					res.body(toJson(new ResponseError(e)));
				});

			/*get("/users", (req, res) -> userService.getAllUsers(), json());

			get("/users/:id", (req, res) -> {
				String id = req.params(":id");
				User user = userService.getUser(id);
				if (user != null) {
					return user;
				}
				res.status(400);
				return new ResponseError("No user with id '%s' found", id);
			}, json());

			post("/users", (req, res) -> userService.createUser(
					req.queryParams("name"),
					req.queryParams("email")
			), json());

			put("/users/:id", (req, res) -> userService.updateUser(
					req.params(":id"),
					req.queryParams("name"),
					req.queryParams("email")
			), json());

			after((req, res) -> {
				res.type("application/json");
			});

			exception(IllegalArgumentException.class, (e, req, res) -> {
				res.status(400);
				res.body(toJson(new ResponseError(e)));
			});*/
		
	   }
	   
	   private static void registerPostApi(RequestContextController reqCtxCtrlr, String apiPath,
				HttpRequestHandler httpReqHandler) {
			System.out.println("Registering [" + apiPath + "]");

			post(apiPath, CONTENT_TYPE_APPLICATION_JSON, (request, response) -> {
	    	  response.type(CONTENT_TYPE_APPLICATION_JSON);
				return HttpServiceHelper.handleApiRequest(reqCtxCtrlr, apiPath, request.body(), request.raw(),
						response.raw(), httpReqHandler);

			});
		}

		private static void registerGetApi(RequestContextController reqCtxCtrlr, String apiPath,
				HttpRequestHandler httpReqHandler) {
			System.out.println("Registering [" + apiPath + "]");

			get(apiPath, CONTENT_TYPE_APPLICATION_JSON, (request, response) -> {
	    	  response.type(CONTENT_TYPE_APPLICATION_JSON);
				return HttpServiceHelper.handleApiRequest(reqCtxCtrlr, apiPath, request.body(), request.raw(),
						response.raw(), httpReqHandler);

			});
		}
		
		private String buildApiPath(String relativePath) {
			return API_PREFIX + relativePath;
		}

}
