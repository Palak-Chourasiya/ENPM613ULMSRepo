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
@RequestMapping(path="/module")

public class CourseModuleController {
	@Autowired
	CourseModuleManagementService moduleService;
	
<<<<<<< HEAD
    @GetMapping("/")
    public ResponseEntity<?> getCourses() {
    	Iterable<CourseModuleEntity> courses = moduleService.getAllModule();
=======
	@GetMapping("/")
	public @ResponseBody String index() {
		return "TEST";
	}
	
    @GetMapping("/showAll")
    public ResponseEntity<?> getCourseModules() {
    	Iterable<CourseModuleEntity> courses = moduleService.getAllCourseModules();
>>>>>>> a0ae400c4174899e3dc381786fc96dbae049efa2
    	if(courses==null) {
    		return new ResponseEntity(new RuntimeException("No courses found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Iterable<CourseModuleEntity>>(courses, HttpStatus.OK);
    }
<<<<<<< HEAD

    @GetMapping("/{course_id}")
    public ResponseEntity<?> getCourse(@PathVariable("course_id") long module_number) {
        CourseModuleEntity course = moduleService.getAllModule(module_number);
    	if(course==null) {
    		return new ResponseEntity(new RuntimeException("Course with id not found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<CourseModuleEntity> (course, HttpStatus.OK);
    }
    
    
=======
    /**
	 * @param module_number
	 * @return Module detail 
	 */
	@GetMapping("/{module_number}")
	public ResponseEntity<?> getModuleDetails(@PathVariable("module_number") long module_number) {
		CourseModuleEntity courseModuleData = moduleService.getModuleDetails(module_number);
		if (courseModuleData == null) {
			return new ResponseEntity(new RuntimeException("Modulewit id" + module_number + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CourseModuleEntity>(courseModuleData, HttpStatus.OK);
	}
    /*
>>>>>>> a0ae400c4174899e3dc381786fc96dbae049efa2
    @RequestMapping(value = "/add", method = RequestMethod.GET)
	public ResponseEntity<?> addModule(@RequestParam("module_number") Long module_number,
			                               @RequestParam("course_id") Long course_id,
			                               @RequestParam("title") String title,
			                               @RequestParam("date_published") ZonedDateTime date_published) {
    	
		// assign parameters to taskDocumentEntity by constructor args or setters
	    CourseModuleEntity module = new CourseModuleEntity();
	    module.setModule_number(module_number);
	    module.setCourse_id(course_id);
	    module.setTitle(title);
	    module.setDate_published(date_published);
	    moduleService.addModule(module);
	    return new ResponseEntity<CourseModuleEntity> (module, HttpStatus.OK);
	}
	
}
