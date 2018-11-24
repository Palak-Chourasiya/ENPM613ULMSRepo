package ulms.courses;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ulms.students.StudentEnrollmentService;

@Controller
@RequestMapping(path="/courses2")
public class CourseController2 {

	@Autowired
	CourseService courseService;
	
    @GetMapping("/")
    public @ResponseBody String index() {
    	/***
    	 * NOTE:	THE GIVEN USER STRING FOR A DATE WILL BE IN THE FORMAT OF
    	 *          MM/DD/YY OR MM/DD/YYYY.  PLUS THE USERS TIME ZONE WILL BE
    	 *          ENTERED AS WELL.  WHEN ENTERED IN THIS FORMAT IT WILL NEED
    	 *          TO BE CONVERTED INTO A ZONED DATE TIME OBJECT THAT WILL BE
    	 *          INSERTED INTO THE DATABASE.  ALL DATETIME SAVED TO THE
    	 *          DATABASE WILL NEED TO BE IN THE UTC TIMEZONE AND DYNAMICALLY
    	 *          CONVERTED FROM/TO THE USER.  IT WILL BE CONVERTED FROM THE
    	 *          USER BECAUSE THE USER WILL BE GIVING US THIS INFORMATION.
    	 *          THE USER TIMEZONE CAN BE AUTOMATICALLY OBTAINED FROM THE
    	 *          USER WITHOUT THEIR INTERACTION OR THE USER CAN EXPLICITLY
    	 *          GIVE THEIR DESIRED TIMEZONE.  
    	 */
    	
    	LocalDate date = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
    	                                  .parse("12/03/11", LocalDate::from);
    	LocalDate date2 = LocalDate.parse("03/28/2017", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    	String formatted = date2.format(DateTimeFormatter.ISO_LOCAL_DATE);
    	ZonedDateTime date3 = ZonedDateTime.parse(formatted + "T12:25:38.492+05:30[Asia/Calcutta]", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    	ZonedDateTime date4 = ZonedDateTime.parse(formatted + "T" + LocalTime.now() + "-04:00[America/New_York]", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    	ZonedDateTime date5 = ZonedDateTime.parse(formatted + "T" + LocalTime.now() + "Z[UTC]", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    	/*
    	Course course = new Course();
    	course.setTitle("");
    	course.setInstructorId(1);
    	course.setStartDate(ZonedDateTime.parse(formatted + "T" + LocalTime.now() + "-04:00[America/New_York]", DateTimeFormatter.ISO_ZONED_DATE_TIME));
    	course.setEndDate(ZonedDateTime.parse(formatted + "T" + LocalTime.now() + "-04:00[America/New_York]", DateTimeFormatter.ISO_ZONED_DATE_TIME));
    	
    	model.addAttribute("", course.getTitle());
    	model.addAttribute("", course.getInstructorId());
    	model.addAttribute("", course.getStartDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
    	model.addAttribute("", course.getEndDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
    	*/
    	
    	ZonedDateTime date6 = ZonedDateTime.parse("FAKE", DateTimeFormatter.ISO_ZONED_DATE_TIME);
    	
        return "TEST";
    }

    @GetMapping("/{course_id}")
    public ResponseEntity<?> getCourse(@PathVariable("course_id") long course_id) {
        CourseEntity course = courseService.getCourse(course_id);
    	if(course==null) {
    		return new ResponseEntity(new RuntimeException("Course with id not found"), HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<CourseEntity> (course,HttpStatus.OK);
    }
    
    
}
