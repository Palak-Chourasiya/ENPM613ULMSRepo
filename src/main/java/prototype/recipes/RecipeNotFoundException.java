package prototype.recipes;

import prototype.entityexceptions.EntityNotFoundException;

/**
 * Exception thrown when requesting a non existent (or no-longer existent) blog post. See
 * sagan-site's {@code MvcConfig#handleException} for handling logic.
 *
 * @see sagan.blog.support.BlogService#getPost(Long)
 * @see sagan.blog.support.BlogService#getPublishedPost(String)
 */
@SuppressWarnings("serial")
public class RecipeNotFoundException extends EntityNotFoundException {

    public RecipeNotFoundException(long id) {
        super("Could not find recipe with id " + id);
    }
}