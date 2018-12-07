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

<<<<<<< HEAD
=======
	@Override
	public String toString() {
		return "MessageFormDto [emails=" + emailText + ", subject=" + subjectText + ", message=" + messageText + ", email=" + email
				+ "]";
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

>>>>>>> 4b7b492be66b1cbddc8bc8adb6daf0c98c8b0319
	public String getEmailText() {
		return emailText;
	}

<<<<<<< HEAD
	public void setEmailText(String emailText) {
		this.emailText = emailText;
=======
	public void setEmailText(String emails) {
		this.emailText = emails;
>>>>>>> 4b7b492be66b1cbddc8bc8adb6daf0c98c8b0319
	}

	public String getSubjectText() {
		return subjectText;
	}

<<<<<<< HEAD
	public void setSubjectText(String subjectText) {
		this.subjectText = subjectText;
=======
	public void setSubjectText(String subject) {
		this.subjectText = subject;
>>>>>>> 4b7b492be66b1cbddc8bc8adb6daf0c98c8b0319
	}

	public String getMessageText() {
		return messageText;
	}

<<<<<<< HEAD
	public void setMessageText(String messageText) {
		this.messageText = messageText;
=======
	public void setMessageText(String message) {
		this.messageText = message;
>>>>>>> 4b7b492be66b1cbddc8bc8adb6daf0c98c8b0319
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}


	
}
