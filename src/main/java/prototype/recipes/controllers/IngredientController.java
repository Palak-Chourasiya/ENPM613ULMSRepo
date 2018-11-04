package prototype.recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import prototype.recipes.models.IngredientEntity;

@Controller
@RequestMapping(path="/ingredients")
public class IngredientController {

	@Autowired
    IngredientService ingredientService; //Service which will do all data retrieval/manipulation work
	
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
    
    @GetMapping("/{ingredientId}")
    public ResponseEntity<?> getUser(@PathVariable("ingredientId") long ingredientId) {
        IngredientEntity ingredient = ingredientService.getIngredient(ingredientId);
        if (ingredient == null) {
            return new ResponseEntity(new RuntimeException("Ingredient with id " + ingredientId 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<IngredientEntity>(ingredient, HttpStatus.OK);
    }

}
