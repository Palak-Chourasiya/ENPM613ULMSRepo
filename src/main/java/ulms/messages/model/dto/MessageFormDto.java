package ulms.messages.model.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ulms.messages.model.dto.MessageReceiverDto.messageFlag;
import ulms.messages.model.entity.messageEntity;
import ulms.messages.model.entity.messageReceiverEntity;

public class MessageFormDto {

	@JsonProperty("emailText")
	private String emailText;
	
	@JsonProperty("subjectText")
	private String subjectText;
	
	@JsonProperty("messageText")
	private String messageText;
	
	List<String> email;

	public List<String> getEmail() {
		List<String> emailList = Arrays.asList(emailText.split(","));
		email = emailList;
		return email;
	}

	@Override
	public String toString() {
		return "MessageFormDto [emails=" + emailText + ", subject=" + subjectText + ", message=" + messageText + ", email=" + email
				+ "]";
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	public String getEmails() {
		return emailText;
	}

	public void setEmails(String emails) {
		this.emailText = emails;
	}

	public String getSubject() {
		return subjectText;
	}

	public void setSubject(String subject) {
		this.subjectText = subject;
	}

	public String getMessage() {
		return messageText;
	}

	public void setMessage(String message) {
		this.messageText = message;
	}
}
