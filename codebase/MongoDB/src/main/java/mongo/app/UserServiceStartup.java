package mongo.app;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import mongo.us.api.UserHttpService;

@ApplicationScoped
public class UserServiceStartup {
	private static final String APP_NAME = "UserService";

	@Inject
	UserHttpService userHttpService;

	public void start(String[] args) {
		initialize(APP_NAME);
		regiseterHttpAPIs();
	}

	private void regiseterHttpAPIs() {
		userHttpService.registerHttpAPIs();
	}

	private void initialize(String appName) {
		System.out.println("App :" + appName + "intializing");

	}

}
