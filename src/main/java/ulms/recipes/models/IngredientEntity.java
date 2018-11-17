package ulms.recipes.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "ingredient")
public class IngredientEntity {
	@Id
	@Column(name="id", unique = true)
	@NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Column(name="name", nullable=false)
	private String name;
	
	@NotNull
	@Column(name="type", nullable=false)
	private String type;
	
	@OneToMany(mappedBy = "ingredient")
    private Set<RecipeIngredientsEntity> ingredientRecipes;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
