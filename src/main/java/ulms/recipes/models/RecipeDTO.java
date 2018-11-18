package ulms.recipes.models;

import java.io.Serializable;

public class RecipeDTO implements Serializable {
	private Long id;
	
	private Long accountId;
	
	private Long courseId;
	
	private String title;
	
	public RecipeDTO() {}
	
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
		this.courseId = courseId;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
}
