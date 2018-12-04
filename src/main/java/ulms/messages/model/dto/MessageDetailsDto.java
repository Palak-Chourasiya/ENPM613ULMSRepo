package ulms.messages.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import ulms.messages.model.dto.MessageReceiverDto.messageFlag;
import ulms.messages.model.entity.messageDetailsEntity;
import ulms.messages.model.entity.messageEntity;
import ulms.messages.model.entity.messageReceiverEntity;

public class MessageDetailsDto {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("user_name")
	private String user_name;
	
	@JsonProperty("send_date")
	private Date send_date;
	
	@JsonProperty("deleted")
	private Boolean deleted;
	
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


	public Date getSend_date() {
		return send_date;
	}


	public void setSend_date(Date send_date) {
		this.send_date = send_date;
	}


	public Boolean getDeleted() {
		return deleted;
	}


	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public messageFlag getMessage_flag() {
		return message_flag;
	}


	public void setMessage_flag(messageFlag message_flag) {
		this.message_flag = message_flag;
	}
	
	public MessageDetailsDto()
	{
		
	}
	
	public MessageDetailsDto(Long id, String user_name, Boolean deleted, Date send_date, String subject, String message, String email, messageFlag message_flag)
	{
		this.id = id;
		this.user_name = user_name;
		this.deleted = deleted;
		this.send_date = send_date;
		this.subject = subject;
		this.message = message;
		this.email = email;
		this.message_flag = message_flag;
	}


	@JsonProperty("subject")
	private String subject;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("message_flag")
	private messageFlag message_flag;

	
	public enum messageFlag {
        read("read"), not_read("not_read"), deleted("deleted");

        private String value;

        messageFlag(String value) { this.value = value; }    

        public String getValue() { return value; }
        
        public static messageFlag fromString(String id)
        {
        	switch(id) 
        	{
        	case "read":
        		return messageFlag.read;
        	case "not_read":
        		return messageFlag.not_read;
        	case "deleted":
        		return messageFlag.deleted;
        	}
        	return messageFlag.not_read;
        }
    }
	public static MessageDetailsDto toEntity(messageDetailsEntity entityItem)
	{
		return new MessageDetailsDto(entityItem.getId(), entityItem.getUser_name(), entityItem.getDeleted(), entityItem.getSend_date(), 
				entityItem.getSubject(), entityItem.getMessage(), entityItem.getEmail(), MessageDetailsDto.messageFlag.fromString(entityItem.getMessage_flag().toString()));
	}
	public static MessageDetailsDto toEntity(MessageDto messageData, MessageReceiverDto entity)
	{
		MessageDetailsDto messageDetail = new MessageDetailsDto();
  		messageDetail.setId(entity.getMessage_id());
  		messageDetail.setEmail(entity.getEmail());
  		messageDetail.setMessage_flag(MessageDetailsDto.messageFlag.fromString(entity.getMessage_flag().toString()));
  		
  		messageDetail.setUser_name(messageData.getUser_name());
  		messageDetail.setDeleted(messageData.isDeleted());
  		messageDetail.setSend_date(messageData.getSend_date());
  		messageDetail.setSubject(messageData.getSubject());
  		messageDetail.setMessage(messageData.getMessage());	
  		return messageDetail;
	}

}
