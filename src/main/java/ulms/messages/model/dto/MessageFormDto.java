package ulms.messages.model.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ulms.messages.model.dto.MessageReceiverDto.messageFlag;
import ulms.messages.model.entity.messageEntity;
import ulms.messages.model.entity.messageReceiverEntity;

public class MessageFormDto {
	private MessageDto sender;
	private List<MessageReceiverDto> receivers;
	
	
	public MessageDto getSender() {
		return sender;
	}
	public void setSender(MessageDto sender) {
		this.sender = sender;
	}
	public List<MessageReceiverDto> getReceivers() {
		return receivers;
	}
	public void setReceiver(List<MessageReceiverDto> receivers) {
		this.receivers = receivers;
	}

}
