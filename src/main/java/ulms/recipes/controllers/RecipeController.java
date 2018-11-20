package ulms.recipes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ulms.recipes.models.RecipeEntity;

@Controller
@RequestMapping(path="/recipes")
public class RecipeController {

	@Autowired
    RecipeService recipeService; //Service which will do all data retrieval/manipulation work
	
    @GetMapping("/")
    public ResponseEntity<?> index() {
    	return new ResponseEntity<List<RecipeEntity>>(recipeService.getAllRecipes(), HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> createRecipe(@RequestBody RecipeEntity recipe, org.springframework.web.util.UriComponentsBuilder uriBuilder) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(uriBuilder.path("recipes/{id}").buildAndExpand(recipe.getId()).toUri());
    	
    	return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @GetMapping("/{recipeId}")
    public ResponseEntity<?> getRecipe(@PathVariable("recipeId") long recipeId) {
        RecipeEntity recipe = recipeService.getRecipe(recipeId);
        if (recipe == null) {
            return new ResponseEntity(new RuntimeException("Recipe with id " + recipeId 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RecipeEntity>(recipe, HttpStatus.OK);
    }
}