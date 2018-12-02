package ulms.messages.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ulms.messages.model.entity.messageReceiverEntity;
import ulms.messages.model.entity.messageReceiverEntity.messageFlag;

public class MessageReceiverDto {
	
	@JsonProperty("message_id")
	private Long message_id;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("message_flag")
	private messageFlag message_flag;
	
	
	public MessageReceiverDto() {}
	public MessageReceiverDto(Long message_id, String email, messageFlag message_flag) {
		this.message_id = message_id;
		this.email = email;
		this.message_flag = message_flag;
	}
	
	
	
	
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




	public messageFlag getMessage_flag() {
		return message_flag;
	}




	public void setMessage_flag(messageFlag message_flag) {
		this.message_flag = message_flag;
	}




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




	@Override
	public String toString() {
		return "MessageReceiverDto [message_id=" + message_id + ", email=" + email + ", message_flag=" + message_flag
				+ "]";
	}
	
	public static List<MessageReceiverDto> toDto(List<messageReceiverEntity> entities)
	{
		List<MessageReceiverDto> returnValue = new ArrayList<>();
		for(messageReceiverEntity entity : entities)
			returnValue.add(MessageReceiverDto.toDto(entity));
		return returnValue;
	}
	
	public static MessageReceiverDto toDto(messageReceiverEntity entity)
	{
		return new MessageReceiverDto(entity.getMessage_id(), entity.getEmail(), messageFlag.fromString(entity.getMessage_flags().toString()));
	}
	
	

}
