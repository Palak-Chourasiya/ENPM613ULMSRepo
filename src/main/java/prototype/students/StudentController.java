package prototype.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



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
	    public ResponseEntity<?> getStudentList(@PathVariable("accountId") long accountId) {
		AccountEntity studentData = student.getStudentList(accountId);
		
		if(studentData==null) {
	     return new ResponseEntity(new RuntimeException("Student with id "+accountId+" not found"), HttpStatus.NOT_FOUND);
     }
     return new ResponseEntity<AccountEntity>(studentData, HttpStatus.OK);
	    }
}
