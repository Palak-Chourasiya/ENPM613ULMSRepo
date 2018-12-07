package ulms.messages.model.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ulms.messages.model.dto.MessageReceiverDto.messageFlag;
import ulms.messages.model.entity.messageEntity;
import ulms.messages.model.entity.messageReceiverEntity;

public class MessageFormDto {

	@Override
	public String toString() {
		return "MessageFormDto [emailText=" + emailText + ", subjectText=" + subjectText + ", messageText="
				+ messageText + ", email=" + email + "]";
	}

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

	public String getEmailText() {
		return emailText;
	}

	public void setEmailText(String emailText) {
		this.emailText = emailText;
	}

	public String getSubjectText() {
		return subjectText;
	}

	public void setSubjectText(String subjectText) {
		this.subjectText = subjectText;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}
	
}
