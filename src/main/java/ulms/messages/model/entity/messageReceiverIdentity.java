package ulms.messages.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ulms.login.models.AccountEntity;
import ulms.students.ParticipantIdentity;

@Embeddable
public class messageReceiverIdentity implements Serializable{
	 public messageReceiverIdentity()
	 {
		 
	 }
	 public messageReceiverIdentity(Long id, String email)
	 {
		this.message_id = id;
		this.email = email;
	 }
	
	
	private Long message_id;
	
	public Long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Long message_id) {
		this.message_id = message_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	private String email;
	

	public int hashCode() {
		  return (int)(this.message_id + Integer.parseInt(this.email));
		 }

		 public boolean equals(Object object) {
		  if (object instanceof messageReceiverIdentity) {
			  messageReceiverIdentity otherId = (messageReceiverIdentity) object;
		   return (otherId.message_id == this.message_id) && (otherId.email == this.email);
		  }
		  return false;
		 }
	
	
	
	@Override
	public String toString() {
		return "messageRecieverKey [id=" + message_id + ", email=" + email + "]";
	}
	
		

}
