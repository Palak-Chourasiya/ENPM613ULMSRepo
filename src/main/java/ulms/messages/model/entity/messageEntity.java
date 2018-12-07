package ulms.messages.model.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import ulms.messages.model.dto.MessageDto;
import ulms.recipes.models.RecipeEntity;
import ulms.recipes.models.RecipeIngredientsEntity;


@Entity
@Table(name = "message")
public class messageEntity {
	@Id
	@Column(name="id", unique = true)
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name")
	private String user_name;
	
	@Column(name="deleted")
	private boolean deleted;
	
	@Column(name="send_date")
	private Date send_date;
	
	@Column(name="message")
	private String message;
	
	@Column(name="subject")
	private String subject;	
	
	
	
    @OneToMany(mappedBy="message")
    private Set<messageReceiverEntity> receivers;
    
    


    public Set<messageReceiverEntity> getReceiverEntity() {
		return receivers;
	}
	
	
	public messageEntity() {
		this.deleted = false;
		this.user_name = "";
		this.subject = "";
		this.message = "";
	}
	
	public long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public Date getSend_date() {
		return send_date;
	}


	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public Set<messageReceiverEntity> getReceivers() {
		return receivers;
	}


	public void setReceivers(Set<messageReceiverEntity> receivers) {
		this.receivers = receivers;
	}


	public messageEntity(String userName, String subject, String message)
	{
		this.user_name = userName;
		this.subject = subject;
		this.message = message;
		this.send_date = new Date();
		this.deleted = false;
	}
	
	
	public messageEntity(Long id, String user_name, Boolean deleted, Date send_date, String subject, String message)
	{
		this.id = id;
		this.user_name = user_name;
		this.deleted = deleted;
		this.send_date = send_date;
		this.subject = subject;
		this.message = message;
	}
	
	
	public static List<messageEntity> toEntity(List<MessageDto> dtoItems){
		List<messageEntity> messageEntities = new ArrayList<>();
		for(MessageDto item : dtoItems)
		{
			messageEntities.add(messageEntity.toEntity(item));
		}
		return messageEntities;
	}
	public static messageEntity toEntity(MessageDto entityItem)
	{
		return new messageEntity(entityItem.getId(), entityItem.getUser_name(), entityItem.isDeleted(), entityItem.getSend_date(), entityItem.getSubject(), entityItem.getMessage());
	}
}
