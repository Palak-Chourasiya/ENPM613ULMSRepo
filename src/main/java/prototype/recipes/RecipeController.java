package prototype.recipes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/recipes")
public class RecipeController {

    @GetMapping("/")
    public @ResponseBody String index() {
    	
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
    	
        return "TEST";
    }

}
