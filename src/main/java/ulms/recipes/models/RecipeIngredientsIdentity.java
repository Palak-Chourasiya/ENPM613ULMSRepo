package ulms.recipes.models;

import java.io.Serializable;

public class RecipeIngredientsIdentity implements Serializable {
    private Long recipeId;

    private Long ingredientId;

    public RecipeIngredientsIdentity() {

    }

    public RecipeIngredientsIdentity(Long recipeId, Long ingredientId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    public Long getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
    
    public Long getIngredientId() {
        return this.ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		RecipeIngredientsIdentity that = (RecipeIngredientsIdentity) obj;
		
		if (this.recipeId == null) {
			if (that.recipeId != null) return false;
		} else if (!this.recipeId.equals(that.recipeId)) return false;
		
		if (this.ingredientId == null) {
			if (that.ingredientId != null) return false;
		} else if (!this.ingredientId.equals(that.ingredientId)) return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.recipeId == null) ? 0 : this.recipeId.hashCode());
		result = prime * result + ((this.ingredientId == null) ? 0 : this.ingredientId.hashCode());
		return result;
	}
}
