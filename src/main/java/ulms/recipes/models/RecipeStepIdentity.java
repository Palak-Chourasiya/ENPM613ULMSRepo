package ulms.recipes.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class RecipeStepIdentity implements Serializable {
	@NotNull
    private Long id;

    @NotNull
    private Long recipeId;

    public RecipeStepIdentity() {

    }

    public RecipeStepIdentity(Long id, Long recipeId) {
        this.id = id;
        this.recipeId = recipeId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		RecipeStepIdentity that = (RecipeStepIdentity) obj;
		
		if (this.id == null) {
			if (that.id != null) return false;
		} else if (!this.id.equals(that.id)) return false;
		
		if (this.recipeId == null) {
			if (that.recipeId != null) return false;
		} else if (!this.recipeId.equals(that.recipeId)) return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result + ((this.recipeId == null) ? 0 : this.recipeId.hashCode());
		return result;
	}
}
