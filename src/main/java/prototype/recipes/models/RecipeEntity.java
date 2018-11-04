package prototype.recipes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "recipe")
public class RecipeEntity {
	@Id
	@Column(unique = true)
	@NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private Long accountId;
	
	private Long courseId;
	
	@NotNull
	private String title;
	
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
}
