package learn.springboot.starter.topics;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class Topic {
	@Id
	@JsonProperty("id")
	private String id;
	@JsonProperty("course_name")
	private String name;
	@JsonProperty("course_description")
	private String description;

	public Topic() {
	}

	public Topic(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
