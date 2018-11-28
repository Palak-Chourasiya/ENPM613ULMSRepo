package ulms.messages;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class messageReceiverKey implements Serializable{
	 public messageReceiverKey()
	 {
		 this.id = null;
		 this.email = null;
	 }
	 public messageReceiverKey(Long id, String email)
	 {
		 this.id = id;
		 this.email = email;
	 }
	
	@Column (name="message_id", nullable = false)
	private Long id;
	@Column (name = "email", nullable = false)
	private String email;
	
	@ManyToOne
    @JoinColumn(name="message_id", insertable=false, updatable=false, referencedColumnName="id")
    private messageEntity message;
	
	
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "messageRecieverKey [id=" + id + ", email=" + email + "]";
	}
	public void setId(long id2) {
		this.id = id2;
		
	}
	
	

}
