package messages;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MessageReceivers")
public class messageReceiverEntity {

	@Column(name="message_id")
	private Long message_id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="message_flags")
	private messageFlag message_flags;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private messageEntity message;
	
	public messageFlag getMessage_flags() {
		return message_flags;
	}
	public void setMessage_flags(messageFlag message_flags) {
		this.message_flags = message_flags;
	}
	public enum messageFlag {
        read("read"), notread("notread"), deleted("deleted");

        private String value;

        messageFlag(String value) { this.value = value; }    

        public String getValue() { return value; }

        public static messageFlag fromString(String id)
        {
        	switch(id) 
        	{
        	case "read":
        		return messageFlag.read;
        	case "notread":
        		return messageFlag.notread;
        	case "deleted":
        		return messageFlag.deleted;
        	}
        	return messageFlag.notread;
           
        }

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
	};
	}
