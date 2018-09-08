package learn.springboot.starter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllTopics(String id) {		
		return courseRepository.findByTopicId(id);	
	}

	public Optional<Course> getTopic(String id) {
		return courseRepository.findById(id);

	}

	public void createTopic(Course course) {
		courseRepository.save(course);
	}

	public void updateTopic( Course course) {
		courseRepository.save(course);

	}

	public void deleteTopic(String id) {
		courseRepository.deleteById(id);
	}

}
