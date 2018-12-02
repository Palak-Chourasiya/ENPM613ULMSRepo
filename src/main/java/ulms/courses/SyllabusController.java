package ulms.courses;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/mediterranean")
    public String mediterraneanSyllabus(HttpServletRequest request) {
		return "/syllabus/syllabusMediterraneanCuisine";
    }
	
	@GetMapping("/sauces")
    public String saucesSyllabus(HttpServletRequest request) {
		return "/syllabus/syllabusSaucesCuisine";
    }
}
