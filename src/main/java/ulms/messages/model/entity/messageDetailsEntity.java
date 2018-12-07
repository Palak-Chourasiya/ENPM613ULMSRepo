package ulms.messages.model.entity;

import java.util.Date;

import ulms.messages.model.dto.MessageDetailsDto;
import ulms.messages.model.dto.MessageDto;

public class messageDetailsEntity {
	private Long id;
	
	private String user_name;
	
	private Date send_date;
	
	private Boolean deleted;
	
	private String senderEmail;
	
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
	
	public messageDetailsEntity()
	{
		
	}
	
	public messageDetailsEntity(Long id, String user_name, String senderEmail, Boolean deleted, Date send_date, String subject, String message, String email, messageFlag message_flag)
	{
		this.id = id;
		this.user_name = user_name;
		this.deleted = deleted;
		this.send_date = send_date;
		this.subject = subject;
		this.message = message;
		this.email = email;
		this.message_flag = message_flag;
		this.senderEmail = senderEmail;
	}


	private String subject;
	
	private String message;
	
	private String email;
	
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
	public static messageDetailsEntity toEntity(MessageDetailsDto entityItem)
	{
		return new messageDetailsEntity(entityItem.getId(), entityItem.getUser_name(), entityItem.getSenderEmail(), entityItem.getDeleted(), entityItem.getSend_date(), 
				entityItem.getSubject(), entityItem.getMessage(), entityItem.getEmail(), messageDetailsEntity.messageFlag.fromString(entityItem.getMessage_flag().toString()));
	}
	
	
	public static messageDetailsEntity toEntity(messageEntity messageData, messageReceiverEntity entity)
	{
  		messageDetailsEntity messageDetail = new messageDetailsEntity();
  		messageDetail.setId(entity.getMessage_id());
  		messageDetail.setEmail(entity.getEmail());
  		messageDetail.setMessage_flag(messageDetailsEntity.messageFlag.fromString(entity.getMessage_flags().toString()));
  		
  		messageDetail.setUser_name(messageData.getUser_name());
  		messageDetail.setDeleted(messageData.isDeleted());
  		messageDetail.setSend_date(messageData.getSend_date());
  		messageDetail.setSubject(messageData.getSubject());
  		messageDetail.setMessage(messageData.getMessage());	
  		return messageDetail;
	}


	public String getSenderEmail() {
		return senderEmail;
	}


	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
}
