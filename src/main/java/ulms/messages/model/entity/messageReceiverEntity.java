package ulms.messages.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ulms.login.models.AccountEntity;
import ulms.messages.model.dto.MessageReceiverDto;
import ulms.messages.model.dto.MessageReceiverDto.messageFlag;

@Entity
@Table(name = "messagereceivers")
@IdClass(messageReceiverIdentity.class)
public class messageReceiverEntity implements Serializable {
	
	public messageReceiverEntity()
	{
//		this.key = new messageReceiverIdentity();
//		this.message_flags = messageFlag.notread;
	}
	
	
	
	public messageReceiverEntity(Long message_id, String email, messageFlag message_flag)
	{
		this.message_id = message_id;
		this.email = email;
		this.message_flag= message_flag;
	}
	
	
	

	@Override
	public String toString() {
		//return "";
		return "messageReceiverEntity [message_id =" + message_id + ", email: "+ email + ", message_flags=" + message_flag.getValue() + "]";
	}

	
	@ManyToOne
	@JoinColumn(name="message_id", insertable=false, updatable=false, referencedColumnName="id")
    private messageEntity message;

	
	@Id
	@Column(name="message_id")
	private Long message_id;
	
	@Id
	@Column(name="email")
	private String email;
	
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


	@Enumerated(EnumType.STRING)
	@Column(name="message_flag")
	private messageFlag message_flag;
	

	public messageFlag getMessage_flags() {
		return message_flag;
	}
	public void setMessage_flags(messageFlag message_flags) {
		this.message_flag = message_flags;
	}
	
	public enum messageFlag {
        read("read"), not_read("not_read"), delete("delete");

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
        	case "delete":
        		return messageFlag.delete;
        	}
        	return messageFlag.not_read;
        }
        
        public String toIndex() {
        	switch (this.value) {
	        	case "read":
	        		return "1";
	        	case "not_read":
	        		return "2";
	        	case "deleted":
	        		return "3";
        		default:
        			return "1";
        	}
        }
    }
	

	
	public static List<messageReceiverEntity> toEntity(List<MessageReceiverDto> entities)
	{
		List<messageReceiverEntity> returnValue = new ArrayList<>();
		for(MessageReceiverDto entity : entities)
			returnValue.add(messageReceiverEntity.toEntity(entity));
		return returnValue;
	}
	
	public static messageReceiverEntity toEntity(MessageReceiverDto entity)
	{
		return new messageReceiverEntity(entity.getMessage_id(), entity.getEmail(), messageFlag.fromString(entity.getMessage_flag().toString()));
	}
	
	
	
	
	
	}
