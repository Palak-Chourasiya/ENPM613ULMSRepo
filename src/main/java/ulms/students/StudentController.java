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
@RequestMapping(path="/CourseRoster")
public class StudentController {

	@Autowired
	StudentEnrollmentService student;
	
	@GetMapping("/")
    public @ResponseBody String index() {
    	
        return "TEST";
    }
	 @GetMapping("/{accountId}")
	    public ResponseEntity<?> getStudentDetails(@PathVariable("accountId") long accountId) {
		AccountEntity studentData = student.getStudentDetails(accountId);
		if(studentData==null) {
	     return new ResponseEntity(new RuntimeException("Student with id "+accountId+" not found"), HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity<AccountEntity>(studentData, HttpStatus.OK);
	    }
	 
	 @GetMapping("/course")
	    public ResponseEntity<?> getAccountId() {
		 Iterable <ParticipantsEntity> course = student.getAccountId();
		if(course==null) {
	     return new ResponseEntity(new RuntimeException("Student with id not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ParticipantsEntity> (HttpStatus.OK);
	    }
	 
	 	@GetMapping("/StudentList")
	    public ResponseEntity<?> getStudentList() {
		Iterable <AccountEntity> studentData = student.getStudentList();
		for(AccountEntity student:studentData) {
			System.out.println(student);
		}
		if(studentData==null) {
	     return new ResponseEntity(new RuntimeException("Student list is empty"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AccountEntity>((AccountEntity)studentData, HttpStatus.OK);
	    }
}
