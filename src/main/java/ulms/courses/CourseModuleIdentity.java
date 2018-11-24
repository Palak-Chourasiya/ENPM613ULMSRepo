package ulms.courses;

import java.io.Serializable;

public class CourseModuleIdentity implements Serializable {
    private Long recipeId;

    private Long ingredientId;

	private Long module_number;

	private Long course_id;

    public CourseModuleIdentity() {

    }

    public CourseModuleIdentity(Long module_number, Long course_id) {
        this.module_number = module_number;
        this.course_id = course_id;
    }

    public Long getModuleNumber() {
        return this.module_number;
    }

    public void setModuleNumber(Long module_number) {
        this.module_number = module_number;
    }
    
    public Long getCourseId() {
        return this.course_id;
    }

    public void setCourseId(Long course_id) {
        this.course_id = course_id;
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
		
		if (this.module_number == null) {
			if (that.module_number != null) return false;
		} else if (!this.module_number.equals(that.module_number)) return false;
		
		if (this.course_id == null) {
			if (that.course_id != null) return false;
		} else if (!this.course_id.equals(that.course_id)) return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.module_number == null) ? 0 : this.module_number.hashCode());
		result = prime * result + ((this.course_id == null) ? 0 : this.course_id.hashCode());
		return result;
	}
}
