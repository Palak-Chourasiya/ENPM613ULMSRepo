package ulms.messages;


import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import ulms.login.AccountEntity;
import ulms.recipes.models.RecipeEntity;
import ulms.recipes.models.RecipeIngredientsEntity;


@Entity
@Table(name = "message")
public class messageEntity {
	
	@Override
	public String toString() {
		return "messageEntity [id=" + id + ", userName=" + userName + ", deleted=" + deleted + ", message=" + message
				+ ", subject=" + subject + ", sendDate=" + sendDate + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@Column(name="message")
	private String message;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="send_date")
	private Date sendDate;
	

	@OneToMany(mappedBy = "message_id")
	private Set<messageReceiverEntity> messageReceiver;
	
//	@ManyToOne
//    @JoinColumn(name="user_name", insertable=false, updatable=false, referencedColumnName="user_name")
//    private AccountEntity account;
	
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
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
	
	public boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.deleted = isDeleted;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public messageEntity()
	{
		this.deleted = false;
		this.userName = "";
		this.subject = "";
		this.message = "";
	}
	
	
		
}
