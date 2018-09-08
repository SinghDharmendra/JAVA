package learn.springboot.starter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonProperty;

import learn.springboot.starter.topics.Topic;
@Entity
public class Course {
	@Id
	@JsonProperty("id")
	private String id;
	@JsonProperty("course_name")
	private String name;
	@JsonProperty("course_description")
	private String description;
	
	@ManyToOne
	private Topic topic;


	public Course() {
	}

	public Course(String id, String name, String description,String topicId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic=new Topic(topicId, "", "");
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
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}


}
