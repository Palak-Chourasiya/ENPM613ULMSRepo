package ulms.recipes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "recipeingredients")
@IdClass(RecipeIngredientsIdentity.class)
public class RecipeIngredientsEntity {
	@Id
	@NotNull
	@Column(name="recipe_id", nullable=false)
	private Long recipeId;
	
	@Id
	@NotNull
	@Column(name="ingredient_id", nullable=false)
	private Long ingredientId;
	 
	@NotNull
	@Column(name="quantity", nullable=false)
	private Double quantity;
	
	@NotNull
	@Column(name="measurement_type", nullable=false)
	private String measurementType;

	@ManyToOne
	@JoinColumn(name="recipe_id", insertable=false, updatable=false, referencedColumnName="id")
	private RecipeEntity recipe;

    @ManyToOne
    @JoinColumn(name="ingredient_id", insertable=false, updatable=false, referencedColumnName="id")
    private IngredientEntity ingredient;

    public Long getRecipeId() {
    	return this.recipeId;
    }
    
    public Long getIngredientId() {
    	return this.ingredientId;
    }
    
    public Double getQuantity() {
    	return this.quantity;
    }
    
    public String getMeasurementType() {
    	return this.measurementType;
    }
}
