package ulms.courses.modules;

public class CourseModuleIdentity {
	private Long courseId;
	private Long module_number;
	
	public CourseModuleIdentity() {

    }

    public CourseModuleIdentity(Long courseId, Long ingredientId) {
        this.courseId = courseId;
        this.module_number = ingredientId;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setRecipeId(Long recipeId) {
        this.courseId = recipeId;
    }
    
    public Long getIngredientId() {
        return this.module_number;
    }

    public void setIngredientId(Long ingredientId) {
        this.module_number = ingredientId;
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		CourseModuleIdentity that = (CourseModuleIdentity) obj;
		
		if (this.courseId == null) {
			if (that.courseId != null) return false;
		} else if (!this.courseId.equals(that.courseId)) return false;
		
		if (this.module_number == null) {
			if (that.module_number != null) return false;
		} else if (!this.module_number.equals(that.module_number)) return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.courseId == null) ? 0 : this.courseId.hashCode());
		result = prime * result + ((this.module_number == null) ? 0 : this.module_number.hashCode());
		return result;
	}
	
}

