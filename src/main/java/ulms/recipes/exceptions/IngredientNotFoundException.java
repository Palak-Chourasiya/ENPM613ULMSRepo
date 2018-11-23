package ulms.recipes.exceptions;

import ulms.entity.exceptions.EntityNotFoundException;

/**
 * Exception thrown when requesting a non existent (or no-longer existent) ingredient.
 */
@SuppressWarnings("serial")
public class IngredientNotFoundException extends EntityNotFoundException {

    public IngredientNotFoundException(long id) {
        super("Could not find ingredient with id " + id);
    }
}