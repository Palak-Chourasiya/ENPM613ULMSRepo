package ulms.courses.modules;

import ulms.students.ParticipantIdentity;

public class CourseModuleIdentity {
	private Long course_id;
	
	public int hashCode() {
		  return course_id.intValue();
		 }

		 public boolean equals(Object object) {
		  if (object instanceof CourseModuleIdentity) {
			  CourseModuleIdentity otherId = (CourseModuleIdentity) object;
		   return (otherId.course_id == this.course_id);
		  }
		  return false;
		 }
	
	public Long getCourse_id() {
		return course_id;	
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	
	}

