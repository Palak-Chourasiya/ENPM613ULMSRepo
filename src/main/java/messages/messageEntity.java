package messages;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "message")
public class messageEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="isRead")
	private boolean isRead;
	
	@Column(name="from")
	private String sender;
	
	@Column(name="message")
	private String message;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="send_date")
	private DateTimeFormat sendDate;
	
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public DateTimeFormat getSendDate() {
		return sendDate;
	}
	public void setSendDate(DateTimeFormat sendDate) {
		this.sendDate = sendDate;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	@Override
	public String toString() {
		return "messageEntity [id=" + id + ", userName=" + userName + ", isRead=" + isRead + ", sender=" + sender
				+ ", message=" + message + "]";
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
		
}
