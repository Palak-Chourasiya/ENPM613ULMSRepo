package ulms.messages.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ulms.messages.model.entity.messageEntity;

public class MessageDto {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("user_name")
	private String user_name;
	
	@JsonProperty("send_date")
	private Date send_date;
	
	@JsonProperty("deleted")
	private Boolean deleted;
	
	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("message")
	private String message;
	
	
	public Boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}

	public MessageDto() {}
	public MessageDto(Long id, String user_name, Boolean deleted, Date send_date, String subject, String message)
	{
		this.id = id;
		this.user_name = user_name;
		this.deleted = deleted;
		this.send_date = send_date;
		this.subject = subject;
		this.message = message;
	}
	public Long getId() {
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
	
	public String getSubject() {
		return subject;
	}
	public Date getSend_date() {
		return send_date;
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
	public static List<MessageDto> toDto(List<messageEntity> entityItems){
		List<MessageDto> messageDtos = new ArrayList<>();
		for(messageEntity item : entityItems)
		{
			messageDtos.add(MessageDto.toDto(item));
		}
		return messageDtos;
	}
	public static MessageDto toDto(messageEntity entityItem)
	{
		return new MessageDto(entityItem.getId(), entityItem.getUser_name(), entityItem.isDeleted(), entityItem.getSend_date(), entityItem.getSubject(), entityItem.getMessage());
	}


}
