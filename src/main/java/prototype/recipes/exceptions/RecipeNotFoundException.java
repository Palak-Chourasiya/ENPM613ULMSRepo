package prototype.recipes.exceptions;

import prototype.entity.exceptions.EntityNotFoundException;

/**
 * Exception thrown when requesting a non existent (or no-longer existent) recipe.
 */
@SuppressWarnings("serial")
public class RecipeNotFoundException extends EntityNotFoundException {

    public RecipeNotFoundException(long id) {
        super("Could not find recipe with id " + id);
    }
}