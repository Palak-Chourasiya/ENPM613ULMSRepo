package ulms.students;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ulms.login.AccountEntity;



@Controller
@RequestMapping(path="/CourseRoaster")
public class StudentController {

	@Autowired
	StudentEnrollmentService student;
	
	@GetMapping("/")
    public @ResponseBody String index() {
    	
        return "TEST";
    }
	/**
	 * @param accountId
	 * @return Account detail for a participant (either Instructor or Student)
	 */
	 @GetMapping("/{accountId}")
	    public ResponseEntity<?> getStudentDetails(@PathVariable("accountId") long accountId) {
		AccountEntity studentData = student.getStudentDetails(accountId);
		if(studentData==null) {
	     return new ResponseEntity(new RuntimeException("Student with id "+accountId+" not found"), HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity<AccountEntity>(studentData, HttpStatus.OK);
	    }
	 @GetMapping("/participants")
	    public ResponseEntity<?> getParticipants() {
		Iterable<ParticipantsEntity>  studentData = student.getAllParticipants();
		if(studentData==null) {
	     return new ResponseEntity(new RuntimeException("No students found"), HttpStatus.NOT_FOUND);
  }
  return new ResponseEntity<Iterable <ParticipantsEntity>>(studentData, HttpStatus.OK);
	    }
	 /**
	  * @return List of Students based on CourseID
	  */
	 @GetMapping("/course/{course_id}")
	    public ResponseEntity<?> getStudentinCourse(@PathVariable("course_id") long course_id) {
		 Iterable <AccountEntity> courseStudents = student.getAllParticipantsInCourse(course_id);
		if(courseStudents==null) {
	     return new ResponseEntity(new RuntimeException("No Students are present in this course"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity< Iterable <AccountEntity>> (courseStudents,HttpStatus.OK);
	    }
	 /**
	  * @return List of all Students enrolled under the ULMS with their details 
	  */
	 	@GetMapping("/StudentList")
	    public  ResponseEntity<Iterable<AccountEntity>> getStudentList() {
	 		Iterable<AccountEntity> studentData = student.getStudentList();
		if(studentData==null) {
			return new ResponseEntity(new RuntimeException("Student Data not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Iterable <AccountEntity>>(studentData, HttpStatus.OK);
	    }
	 	 /**
		  * @return List of all instructors in the ULMS with their details 
		  */
		 	@GetMapping("/InstructorList")
		    public  ResponseEntity<Iterable<AccountEntity>> getInstructorList() {
		 		Iterable<AccountEntity> instructorData = student.getInstructorList();
			if(instructorData==null) {
				return new ResponseEntity(new RuntimeException("Instructor Data not found"), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Iterable <AccountEntity>>(instructorData, HttpStatus.OK);
		    }
	 	
	 	
}
