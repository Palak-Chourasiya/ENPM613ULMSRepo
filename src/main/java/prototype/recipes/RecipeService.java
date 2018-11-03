package prototype.recipes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Service providing high-level, selectively cached data access and other {@link Recipe}
 * -related operations.
 */
@Service
public class RecipeService {
    public static final String CACHE_NAME = "cache.recipe";
    public static final Class CACHE_TYPE = RecipeEntity.class;
    public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";

    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // Property methods

    // Query methods

    public RecipeEntity getRecipe(Long recipeId) {
        Optional<RecipeEntity> recipe = recipeRepository.findById(recipeId);
        if (!recipe.isPresent()) {
            throw new RecipeNotFoundException(recipeId);
        }
        return recipe.get();
    }
    
    public Page<RecipeEntity> getAllRecipes(Pageable pageRequest) {
        return recipeRepository.findAll(pageRequest);
    }
    
    public void addRecipe(RecipeEntity newRecipe) {
        recipeRepository.save(newRecipe);
    }
}