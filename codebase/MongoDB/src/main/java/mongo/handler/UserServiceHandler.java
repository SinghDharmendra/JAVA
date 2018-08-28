package mongo.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mongo.dao.MongoDS;
import mongo.entity.User;
import mongo.util.JsonUtil;

@RequestScoped
public class UserServiceHandler {
	@Inject
	MongoDS ds = new MongoDS();

	private Map<String, User> users = new HashMap<>();

	public List<User> getAllUsers() {
		return ds.getUsers();

	}

	public User getUser(String id) {
		return users.get(id);
	}

	public User createUser(String name, String email) {
		failIfInvalid(name, email);
		User user = new User(name, email);
		users.put(user.getId(), user);
		ds.insert(user);
		return user;
	}

	public User updateUser(String id, String name, String email) {
		User user = users.get(id);
		if (user == null) {
			throw new IllegalArgumentException("No user with id '" + id + "' found");
		}
		failIfInvalid(name, email);
		user.setName(name);
		user.setEmail(email);
		return user;
	}

	private void failIfInvalid(String name, String email) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'name' cannot be empty");
		}
		if (email == null || email.isEmpty()) {
			throw new IllegalArgumentException("Parameter 'email' cannot be empty");
		}
	}

	public String generateUser(String jsonReqStr, HttpServletRequest httpServletReq,
			HttpServletResponse httpServletRes) {
		System.out.println("Request:\n" + jsonReqStr);
		User user = JsonUtil.toObject(User.class, jsonReqStr);

		failIfInvalid(user.getName(), user.getEmail());
		System.out.println(user);
		user.setId(UUID.randomUUID().toString());

		users.put(user.getId(), user);
		ds.insert(user);
		return "{\"status\":\"user-created\"}";
	}
}
