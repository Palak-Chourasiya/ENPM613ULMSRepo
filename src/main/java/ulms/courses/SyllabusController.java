package ulms.courses;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
@RequestMapping(path="/syllabus")
public class SyllabusController {

	@GetMapping("/american")
    public String americanSyllabus(HttpServletRequest request) {
		return "/syllabus/syllabusAmericanCuisine";
    }
	
	@GetMapping("/baking")
    public String bakingSyllabus(HttpServletRequest request) {
		return "/syllabus/syllabusBaking";
    }
	
	@GetMapping("/indian")
    public String indianSyllabus(HttpServletRequest request) {
		return "/syllabus/syllabusIndianCuisine";
    }
	
	@GetMapping("/japanese")
    public String japaneseSyllabus(HttpServletRequest request) {
		return "/syllabus/syllabusJapaneseCuisine";
    }
	
	@GetMapping("/mexican")
    public String mexicanSyllabus(HttpServletRequest request) {
		return "/syllabus/syllabusMexicanCuisine";
    }
}
