package prototype.recipes.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "recipesteps")
public class RecipeStepEntity {
	@EmbeddedId
    private RecipeStepIdentity recipeStepIdentity;
	
	@NotNull
	private String stepDetails;
	
	/*
	@Lob
	private byte[] image;
	*/
	
	public RecipeStepIdentity getRecipeStepIdentity() {
		return this.recipeStepIdentity;
	}
	
	public void setId(RecipeStepIdentity recipeStepIdentity) {
		this.recipeStepIdentity = recipeStepIdentity;
	}
}
