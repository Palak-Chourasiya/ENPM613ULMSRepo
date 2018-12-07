package ulms.courses.modules;

import java.time.ZonedDateTime;
import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ulms.courses.CourseEntity;

@Controller
@RequestMapping(path="/module")

public class CourseModuleController {
	@Autowired
	CourseModuleManagementService moduleService;

	@GetMapping("/")
	public ResponseEntity<?> getCourseModules() {
    	Iterable<CourseModuleEntity> courses = moduleService.getAllCourseModules();

    	if(courses==null) {
    		return new ResponseEntity(new RuntimeException("No courses found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<Iterable<CourseModuleEntity>>(courses, HttpStatus.OK);
    }

    /**
	 * @param module_number
	 * @return Module detail 
	 */
	@GetMapping("/{module_number}")
	public ResponseEntity<?> getModuleDetails(@PathVariable("module_number") long module_number) {
		CourseModuleEntity courseModuleData = moduleService.getModuleDetails(module_number);
		if (courseModuleData == null) {
			return new ResponseEntity(new RuntimeException("Module with id" + module_number + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CourseModuleEntity>(courseModuleData, HttpStatus.OK);
	}
   
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ROLE_Instructor')")
    /*
	public ResponseEntity<?> addModule(@RequestParam("module_number") Long module_number,
			                               @RequestParam("course_id") Long course_id,
			                               @RequestParam("title") String title,
			                               @RequestParam("date_published") Date date_published,
			                               @RequestParam("recipe_link") String recipe_link) {*/
    
    public ResponseEntity<?> addModule(@RequestBody CourseModuleEntity module) {
    	/*
	    CourseModuleEntity module = new CourseModuleEntity();
	    module.setModule_number(module_number);
	    module.setCourse_id(course_id);
	    module.setTitle(title);
	    module.setRecipe_link(recipe_link);
	    module.setDate_published(date_published);*/
    	List<CourseModuleEntity> courses = moduleService.getAllCourseModules();
    	int moduleNo=courses.size();
    	module.setModuleNumber((long)moduleNo+1);
	    moduleService.addModule(module);
	    return new ResponseEntity<CourseModuleEntity> (module, HttpStatus.OK);
	}
	
    @RequestMapping(value="/delete/{module_number}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> deleteModule(@PathVariable("module_number") long module_number) {
    	moduleService.deleteModule(module_number);
    	Iterable<CourseModuleEntity> courseModuleData= moduleService.getAllCourseModules();
    	return new ResponseEntity<Iterable<CourseModuleEntity>>(courseModuleData, HttpStatus.OK);
	}
  
    @GetMapping("/courseModule/{course_id}")
    public ResponseEntity<?> getModulesforCourse(@PathVariable("course_id") long course_id) {
    	Iterable<CourseModuleEntity> courseModuleData= moduleService.getModulesforCourse(course_id);
    	if(courseModuleData==null) {
    		return new ResponseEntity(new RuntimeException("Modules are not present in the course with id" + course_id),
					HttpStatus.NOT_FOUND);
    	}
		return  new ResponseEntity<Iterable<CourseModuleEntity>>(courseModuleData, HttpStatus.OK);
	} 
	
    
}
