package ulms.courses.modules;

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
@RequestMapping(path="/courses/module")
public class CourseModuleController {

	@Autowired
	CourseModuleManagementService moduleService;
	
    @GetMapping("/")
    public ResponseEntity<?> getCourses() {
    	Iterable<CourseModuleEntity> courses = moduleService.getAllModules();
    	if(courses==null) {
    		return new ResponseEntity(new RuntimeException("No courses found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Iterable<CourseModuleEntity>>(courses, HttpStatus.OK);
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<?> getCourse(@PathVariable("course_id") long course_id) {
        CourseModuleEntity course = moduleService.getCourse(course_id);
    	if(course==null) {
    		return new ResponseEntity(new RuntimeException("Course with id not found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<CourseModuleEntity> (course, HttpStatus.OK);
    }
    
    /*
    @RequestMapping(value = "/add", method = RequestMethod.GET)
	public ResponseEntity<?> addMessage(@RequestParam("title") String title,
			                               @RequestParam("details") String details,
			                               @RequestParam("instructor_id") Long instructor_id,
			                               @RequestParam("start_date") String start_date,
			                               @RequestParam("end_date") String end_date) {
		// assign parameters to taskDocumentEntity by constructor args or setters
	    CourseEntity course = new CourseEntity();
	    course.setTitle(title);
	    course.setDetails(details);
	    course.setInstructorId(instructor_id);
	    course.setStartDate(start_date);
	    course.setEndDate(end_date);
	    courseService.addCourse(course);
	    return new ResponseEntity<CourseEntity> (course, HttpStatus.OK);
	}
	*/
}
