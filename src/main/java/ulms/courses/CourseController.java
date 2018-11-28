package ulms.courses;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ulms.login.models.AccountEntity;
import ulms.messages.messageEntity;
import ulms.students.StudentEnrollmentService;

@Controller
@RequestMapping(path="/courses")
public class CourseController {

	@Autowired
	CourseManagementService courseManagementService;
	
    @GetMapping("/")
    public ResponseEntity<?> getCourses() {
    	Iterable<CourseEntity> courses = courseManagementService.getAllCourses();
    	if(courses==null) {
    		return new ResponseEntity(new RuntimeException("No courses found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Iterable<CourseEntity>>(courses, HttpStatus.OK);
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<?> getCourse(@PathVariable("course_id") long course_id) {
        CourseEntity course = courseManagementService.getCourse(course_id);
    	if(course==null) {
    		return new ResponseEntity(new RuntimeException("Course with id not found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<CourseEntity> (course, HttpStatus.OK);
    }
}
