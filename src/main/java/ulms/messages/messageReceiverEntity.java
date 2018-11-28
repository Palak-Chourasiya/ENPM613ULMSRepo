package ulms.messages;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ulms.login.models.AccountEntity;

@Entity
@Table(name = "MessageReceivers")
public class messageReceiverEntity {
	
	public messageReceiverEntity()
	{
		this.key = new messageReceiverKey();
		this.message_flags = messageFlag.notread;
	}

	@Override
	public String toString() {
		return "messageReceiverEntity [key=" + key + ", message_flags=" + message_flags + "]";
	}

	@EmbeddedId
	private messageReceiverKey key;
	
	@Column(name="message_flags")
	private messageFlag message_flags;
	
	public messageReceiverKey getKey() {
		return key;
	}
	public void setKey(messageReceiverKey key) {
		this.key = key;
	}
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
