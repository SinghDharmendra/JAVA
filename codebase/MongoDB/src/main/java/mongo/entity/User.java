package mongo.entity;

import java.util.UUID;

import javax.jms.JMSSessionMode;

import com.google.gson.annotations.SerializedName;

public class User {

	@SerializedName("u_id")
	private String id;
	@SerializedName("u_name")
	private String name;
	@SerializedName("u_email")
	private String email;

	public User(String name, String email) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}