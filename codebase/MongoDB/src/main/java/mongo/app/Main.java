package mongo.app;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Main {
	public static void main(String[] args) {
		
		SeContainer container = SeContainerInitializer.newInstance().initialize();
		UserServiceStartup serviceStartup = container.select(UserServiceStartup.class).get();
		serviceStartup.start(args);
	}

}
