package ulms.messages;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ulms.login.models.AccountEntity;

@Entity
@Table(name = "MessageReceivers")
@IdClass(messageReceiverIdentity.class)
public class messageReceiverEntity implements Serializable {
	
	public messageReceiverEntity()
	{
//		this.key = new messageReceiverIdentity();
//		this.message_flags = messageFlag.notread;
	}

	@Override
	public String toString() {
		return "";
		//return "messageReceiverEntity [key=" + key + ", message_flags=" + message_flags + "]";
	}

	
	@ManyToOne
	@JoinColumn(name="message_id",insertable=false, updatable=false)
    private messageEntity message;

	
	@Id
	@Column(name="message_id")
	private long message_id;
	
	@Id
	@Column(name="email")
	private String email;
	
	public long getMessage_id() {
		return message_id;
	}

	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="message_flags")
	private messageFlag message_flags;
	

	public messageFlag getMessage_flags() {
		return message_flags;
	}
	public void setMessage_flags(messageFlag message_flags) {
		this.message_flags = message_flags;
	}
	
	public enum messageFlag {
        read("read"), notread("not_read"), deleted("deleted");

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
        		return messageFlag.notread;
        	case "deleted":
        		return messageFlag.deleted;
        	}
        	return messageFlag.notread;
        }
    }
	}
