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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import ulms.login.models.AccountEntity;
import ulms.recipes.models.RecipeEntity;
import ulms.recipes.models.RecipeIngredientsEntity;


@Entity
@Table(name = "message")
public class messageEntity {
	@Id
	@Column(name="id", unique = true)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long message_id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@Column(name="send_date")
	private Date sendDate;
	
	@Column(name="message")
	private String message;
	
	@Column(name="subject")
	private String subject;	
	
    @OneToMany(mappedBy="message")
    private Set<messageReceiverEntity> receivers;


    public Set<messageReceiverEntity> getReceiverEntity() {
		return receivers;
	}
	
	
	
		
//	@ManyToOne
//    @JoinColumn(name="user_name", insertable=false, updatable=false, referencedColumnName="user_name")
//    private AccountEntity account;
	
	public messageEntity() {
		this.deleted = false;
		this.userName = "";
		this.subject = "";
		this.message = "";
	}
	
	public messageEntity(String userName, String subject, String message)
	{
		this.deleted = false;
		this.userName = userName;
		this.subject = subject;
		this.message = message;
		this.sendDate = new Date();
		this.message_id = (Long) null;
		
	}
	
	public long getId() {
		return message_id;
	}
	
	public void setId(long id) {
		this.message_id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public boolean getDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean isDeleted) {
		this.deleted = isDeleted;
	}
	
	public Date getSendDate() {
		return sendDate;
	}
	
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "messageEntity [id=" + message_id + ", userName=" + userName + ", deleted=" + deleted + ", message=" + message
				+ ", subject=" + subject + ", sendDate=" + sendDate + "]";
	}		
}
