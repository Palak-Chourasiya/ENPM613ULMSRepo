package ulms.recipes.models;

import java.io.Serializable;

public class RecipeAccountsIdentity implements Serializable {
    private Long recipeId;

    private Long accountId;

    public RecipeAccountsIdentity() {

    }

    public RecipeAccountsIdentity(Long recipeId, Long accountId) {
        this.recipeId = recipeId;
        this.accountId = accountId;
    }

    public Long getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
    
    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		RecipeAccountsIdentity that = (RecipeAccountsIdentity) obj;
		
		if (this.recipeId == null) {
			if (that.recipeId != null) return false;
		} else if (!this.recipeId.equals(that.recipeId)) return false;
		
		if (this.accountId == null) {
			if (that.accountId != null) return false;
		} else if (!this.accountId.equals(that.accountId)) return false;
		
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
		result = prime * result + ((this.accountId == null) ? 0 : this.accountId.hashCode());
		return result;
	}
}
