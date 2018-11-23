package ulms.recipes.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.recipes.exceptions.IngredientNotFoundException;
import ulms.recipes.exceptions.RecipeNotFoundException;
import ulms.recipes.models.IngredientEntity;
import ulms.recipes.models.IngredientRepository;
import ulms.recipes.models.RecipeEntity;
import ulms.recipes.models.RecipeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Service providing high-level, selectively cached data access and other {@link IngredientEntity}
 * -related operations.
 */
@Service
public class IngredientService {
    public static final String CACHE_NAME = "cache.recipe";
    public static final Class CACHE_TYPE = RecipeEntity.class;
    public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    // Property methods

    // Query methods

    public IngredientEntity getIngredient(Long ingredientId) {
        Optional<IngredientEntity> ingredient = ingredientRepository.findById(ingredientId);
        if (!ingredient.isPresent()) {
            throw new IngredientNotFoundException(ingredientId);
        }
        return ingredient.get();
    }
    
    public Page<IngredientEntity> getAllIngredients(Pageable pageRequest) {
        return ingredientRepository.findAll(pageRequest);
    }
    
    public void addRecipe(IngredientEntity newIngredient) {
        ingredientRepository.save(newIngredient);
    }
}