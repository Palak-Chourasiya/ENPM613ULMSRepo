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
	
	@Column(name="account_id", nullable=false)
	private Long accountId;
	
	@Column(name="course_id", nullable=false)
	private Long courseId;
	
	@NotNull
	private String title;
	
	@OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredientsEntity> recipeIngredients;
	
	@OneToMany(mappedBy = "recipe")
	private Set<RecipeStepsEntity> recipeSteps;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
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
	
	/*** TODO: ADD RELATIONSHIP TO THE LINKED ACCOUNT ***/
	/*** TODO: ADD RELATIONSHIP TO THE LINKED COURSE ***/
	/*** TODO: ADD RELATIONSHIP TO THE LINKED RECIPE STEPS ***/
}
