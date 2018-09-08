package learn.springboot.starter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import learn.springboot.starter.topics.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService topicService;

	@RequestMapping(value="topics/{topicId}/courses",method=RequestMethod.GET)
	public List<Course> getTopics(@PathVariable String topicId) {
		return topicService.getAllTopics(topicId);

	}

	@RequestMapping(value="/topics/{topicId}/course/{courseId}",method=RequestMethod.GET)
	public Optional<Course> getTopic(@PathVariable String courseIdId) {
		return topicService.getTopic(courseIdId);

	}
	@RequestMapping(value="/topics/{topicId}/courses",method=RequestMethod.POST)
	public void createTopic(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		topicService.createTopic(course);
	}
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}",method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Course course,@PathVariable String courseId,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		topicService.updateTopic(course);
	}
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String courseId) {
		topicService.deleteTopic(courseId);
	}

}
