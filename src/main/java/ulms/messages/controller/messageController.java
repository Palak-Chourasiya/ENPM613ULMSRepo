package ulms.messages.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import ulms.courses.CourseEntity;
import ulms.login.controllers.AccountService;
import ulms.login.controllers.LoginLogoutService;
import ulms.login.models.AccountEntity;
import ulms.login.models.LoginEntity;
import ulms.messages.model.dto.MessageDto;
import ulms.messages.model.dto.MessageFormDto;
import ulms.messages.model.dto.MessageReceiverDto;
import ulms.messages.model.entity.messageDetailsEntity;
import ulms.messages.model.entity.messageEntity;
import ulms.messages.model.entity.messageReceiverEntity;
import ulms.messages.model.entity.messageReceiverEntity.messageFlag;
import ulms.messages.service.messageService;
import ulms.messages.service.messageReceiverService;
import ulms.recipes.models.RecipeEntity;

@Controller
@RequestMapping(path="/messages")
public class messageController {
	
	@Autowired
	messageService messService;
	
	@Autowired
	messageReceiverService messReceiverService;
	
	@Autowired
	LoginLogoutService loginService;
	
	@Autowired 
	AccountService accountService;
	
	
	

 	@GetMapping("/{messageId}")
    public ResponseEntity<?> getMessage(@PathVariable("messageId") Long messageId)
    {
		messageEntity messageData = messService.getMessage(messageId);
		if (messageData == null)
			return new ResponseEntity<>("Message not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(MessageDto.toDto(messageData), HttpStatus.OK);
    }
    
//	 @GetMapping("/course/{course_id}")
//	    public ResponseEntity<?> getStudentsinCourse(@PathVariable("course_id") long course_id) {
//		 Iterable <AccountEntity> courseStudents = student.getAllParticipantsInCourse(course_id);
//		if(courseStudents==null) {
//	     return new ResponseEntity(new RuntimeException("No Students are present in this course"), HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Iterable<AccountEntity>>(courseStudents, HttpStatus.OK);
//	 }
// 	
 	
    @RequestMapping(value="/get/{email}/{message_flag}" ,method = RequestMethod.GET)
    public ResponseEntity<?> getMessageIds(@PathVariable("email") String email,
    		@PathVariable("message_flag") String flag){
    	List<messageReceiverEntity> receiverData = messReceiverService.getMessageByEmail(email, messageReceiverEntity.messageFlag.fromString(flag));
    	List<messageDetailsEntity> messageDetails = new ArrayList<>();
      	for(messageReceiverEntity entity : receiverData)
      	{
      		messageDetailsEntity messageDetail = messageDetailsEntity.toEntity(messService.getMessage(entity.getMessage_id()), entity);	
      		messageDetails.add(messageDetail);
      	}
    	return new ResponseEntity<Iterable<messageDetailsEntity>>(messageDetails, HttpStatus.OK);
    }
    
    //Delete Message
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>  deleteMessage(@PathVariable("id") Long messageId) {
    	messageEntity messageData = messService.getMessage(messageId);
    	messageData.setDeleted(true);
    	messService.updateMessage(messageData);
        return new ResponseEntity<>(messageData, HttpStatus.OK);
	}
    
    
    @RequestMapping(value = "/delete/{id}/{email}", method = RequestMethod.PUT)
	public ResponseEntity<?>  deleteMessage(@PathVariable("id") Long messageId, @PathVariable("email") String email) {
    	messageReceiverEntity messageData = messReceiverService.findById(messageId, email);
    	messageData.setMessage_flags(messageReceiverEntity.messageFlag.deleted);
    	messReceiverService.update(messageData);
        return new ResponseEntity<>(messageId, HttpStatus.OK);

	}
    
    @GetMapping("/")
	public @ResponseBody String test()
	{
		return "This is a test";
	}

    
    //Add Message
	@RequestMapping(value = "/{userName}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> addMessage(@PathVariable("userName") String userName, @RequestBody MessageFormDto messageDto)
	{
		LoginEntity account = loginService.getAccount(userName);
		if (account == null)
		{
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		
		for(MessageReceiverDto receiver : messageDto.getReceivers())
		{
			if(accountService.getMessageByEmail(receiver.getEmail()) == null)
				return new ResponseEntity<>("Receivers not found", HttpStatus.NOT_FOUND); 
		}
		messageEntity messageData = messageEntity.toEntity(messageDto.getSender());
		messageData.setSend_date(new Date());
		messService.addMessage(messageData);
		for(messageReceiverEntity receiverData : messageReceiverEntity.toEntity(messageDto.getReceivers()))
		{
			receiverData.setMessage_id(messageData.getId());
			receiverData.setMessage_flags(messageReceiverEntity.messageFlag.not_read);
			messReceiverService.addMessageReceiver(receiverData);
		}
        return new ResponseEntity<>(messageDto, HttpStatus.CREATED);
	}
	
	

	

    
    
   

}
