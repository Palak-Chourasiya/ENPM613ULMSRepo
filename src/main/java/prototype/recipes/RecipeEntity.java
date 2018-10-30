package prototype.recipes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class RecipeEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private Integer accountId;
	
	private Integer courseId;
	
	private String title;
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getAccountId() {
		return this.accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public Integer getCourseId() {
		return this.courseId;
	}
	
	public void setCourseId(Integer courseId) {
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
