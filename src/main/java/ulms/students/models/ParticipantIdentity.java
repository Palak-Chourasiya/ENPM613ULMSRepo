package ulms.students.models;

import java.io.Serializable;

public class ParticipantIdentity implements Serializable{
	private Long course_id;
	
	private Long account_id;
	
	
	
	public int hashCode() {
		  return (int)(course_id + account_id);
		 }

		 public boolean equals(Object object) {
		  if (object instanceof ParticipantIdentity) {
			  ParticipantIdentity otherId = (ParticipantIdentity) object;
		   return (otherId.account_id == this.account_id) && (otherId.course_id == this.course_id);
		  }
		  return false;
		 }
	
	public Long getCourse_id() {
		return course_id;	
	}
	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}
	public Long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	
}
