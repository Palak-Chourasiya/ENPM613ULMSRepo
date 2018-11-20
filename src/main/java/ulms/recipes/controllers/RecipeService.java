package ulms.recipes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.recipes.exceptions.RecipeNotFoundException;
import ulms.recipes.models.IngredientRepository;
import ulms.recipes.models.RecipeDTO;
import ulms.recipes.models.RecipeEntity;
import ulms.recipes.models.RecipeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Service providing high-level, selectively cached data access and other {@link RecipeEntity}
 * -related operations.
 */
@Service
public class RecipeService {
    public static final String CACHE_NAME = "cache.recipe";
    public static final Class CACHE_TYPE = RecipeEntity.class;
    public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    // Property methods

    // Query methods

    public RecipeEntity getRecipe(Long recipeId) {
        Optional<RecipeEntity> recipe = recipeRepository.findById(recipeId);
        if (!recipe.isPresent()) {
            throw new RecipeNotFoundException(recipeId);
        }
        
        RecipeEntity entity = recipe.get();
        RecipeDTO dto = new RecipeDTO();
        BeanUtils.copyProperties(entity, dto);
        
        return recipe.get();
    }
    
    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }
    
    public void addRecipe(RecipeEntity newRecipe) {
        recipeRepository.save(newRecipe);
    }
}