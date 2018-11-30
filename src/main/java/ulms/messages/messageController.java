package ulms.messages;


import java.util.Date;

import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ulms.messages.messageEntity;
import ulms.messages.messageReceiverEntity.messageFlag;

@Controller
@RequestMapping(path="/message")
public class messageController {
	
	@Autowired
	MessageService messService;
	
	@Autowired
	messageReceiverService messReceiverService;
	
	@GetMapping("/")
	public @ResponseBody String index() {
		return "TEST";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody String addMessage(@RequestParam("user_name") String user_name,
			                               @RequestParam("subject") String subject,
			                               @RequestParam("message") String message,
			                               @RequestParam("receivers") String receivers) {
		// assign parameters to taskDocumentEntity by constructor args or setters
	    messageEntity messageData = new messageEntity(user_name, subject, message);
	    messService.addMessage(messageData);
	    
	    for(String receiver : receivers.split(";"))
	    {
	    	messageReceiverEntity messageReceiverData = new messageReceiverEntity();
	    	messageReceiverIdentity messKey = new messageReceiverIdentity();
	    	messageReceiverData.setMessage_id(messageData.getId());
	    	messageReceiverData.setEmail(receiver);
	    	messageReceiverData.setMessage_flags(messageFlag.notread);
	    	messReceiverService.addMessageReceiver(messageReceiverData);
	    }
	    	
	    
	    return messageData.toString();
	}
	
	@GetMapping("/delete/{id}")
	public @ResponseBody String deleteMessage(@PathVariable("id") long messageId) {
		messService.deleteMessage(messageId);
		return "Success";
	}
	 
	@GetMapping("/message/{id}")
	public ResponseEntity<?> getMessageDetails(@PathVariable("id") long messageId) {
		messageEntity messagetData = messService.getMessage(messageId);
		if(messagetData==null) {
	     return new ResponseEntity(new RuntimeException("Message with id "+messageId+" not found"), HttpStatus.NOT_FOUND);
		}
	    return new ResponseEntity<messageEntity>(messagetData, HttpStatus.OK);
	}
}
