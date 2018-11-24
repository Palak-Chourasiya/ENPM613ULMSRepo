package ulms.recipes.models;

import java.util.List;
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
@Table(name = "recipe")
public class RecipeEntity {
	@Id
	@Column(name="id", unique = true)
	@NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="course_id", nullable=false)
	private Long courseId;
	
	@NotNull
	@Column(name="title", nullable=false)
	private String title;
	
	@NotNull
	@Column(name="overview", nullable=false)
	private String overview;
	
	@OneToMany(mappedBy = "recipe")
	private List<RecipeAccountsEntity> recipeAccounts;
	
	@OneToMany(mappedBy = "recipe")
    private List<RecipeIngredientsEntity> recipeIngredients;
	
	@OneToMany(mappedBy = "recipe")
	private List<RecipeStepsEntity> recipeSteps;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCourseId() {
		return this.courseId;
	}
	
	public void setCourseId(Long courseId) {
		this.courseId  = courseId;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getOverview() {
		return this.overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public List<RecipeAccountsEntity> getRecipeAccounts() {
		return this.recipeAccounts;
	}
	
	public List<RecipeIngredientsEntity> getRecipeIngredients() {
		return this.recipeIngredients;
	}

	public List<RecipeStepsEntity> getRecipeSteps() {
		return this.recipeSteps;
	}
	
	/*** TODO: ADD RELATIONSHIP TO THE LINKED ACCOUNT ***/
	/*** TODO: ADD RELATIONSHIP TO THE LINKED COURSE ***/
}
