package ulms.messages.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

 	public AccountEntity getCurrentAccout()
 	{
 	   	LoginEntity login = this.getLoginEntity();
    	AccountEntity account;
	    account = accountService.getAccount(login.getAccountId());
	    if (account == null) {
	    	return new AccountEntity();
	    }
    	return account;
 	}
 	
 	public LoginEntity getLoginEntity()
 	{
 		String authenticatedUserName = "";
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
    		authenticatedUserName = authentication.getName();
    	}
    	
    	LoginEntity login = loginService.getLogin(authenticatedUserName);
    	if (login == null)
    		return new LoginEntity();
    	return login;
 	}
 	
 	
 	
    @RequestMapping(value="/getEmail" ,method = RequestMethod.GET)
    public ResponseEntity<?> getMessageIds(){
    	AccountEntity account = this.getCurrentAccout();
    	List<messageReceiverEntity> receiverData = messReceiverService.getMessageByEmail(account.getEmail(), messageReceiverEntity.messageFlag.not_read);
    	receiverData.addAll(messReceiverService.getMessageByEmail(account.getEmail(), messageReceiverEntity.messageFlag.read));
    	List<messageDetailsEntity> messageDetails = new ArrayList<>();
      	for(messageReceiverEntity entity : receiverData)
      	{
      		messageEntity messEntity = messService.getMessage(entity.getMessage_id());
      		String userName = messEntity.getUser_name();
      		Long id = loginService.getLogin(userName).getAccountId();
      		String email = accountService.getAccount(id).getEmail();

      		messageDetailsEntity messageDetail = messageDetailsEntity.toEntity(messEntity, entity);	
      		messageDetail.setSenderEmail(email);
      		messageDetails.add(messageDetail);
      	}
    	return new ResponseEntity<Iterable<messageDetailsEntity>>(messageDetails, HttpStatus.OK);
    }
    
    //Delete Message
    @RequestMapping(value = "/SenderDelete/{id}", method = RequestMethod.GET)
	public ResponseEntity<?>  deleteSenderMessage(@PathVariable("id") Long messageId) {
    	messageEntity messageData = messService.getMessage(messageId);
    	messageData.setDeleted(true);
    	messService.updateMessage(messageData);
        return new ResponseEntity<>(messageData, HttpStatus.OK);
	}
    
    
    //Delete Message
    @RequestMapping(value = "/sent", method = RequestMethod.GET)
	public ResponseEntity<?>  getSentMessage() {
    	LoginEntity login = this.getLoginEntity();
    	List<messageEntity> messages = messService.getMessageByUserName(login.getUserName());
    	return new ResponseEntity<Iterable<messageEntity>>(messages, HttpStatus.OK);
    	
	}
    
    //Delete Message
    @RequestMapping(value = "/trash", method = RequestMethod.GET)
	public ResponseEntity<?>  getDeletedMessage() {
    	AccountEntity account = this.getCurrentAccout();
    	List<messageReceiverEntity> receiverData = messReceiverService.getMessageByEmail(account.getEmail(), messageReceiverEntity.messageFlag.delete);
    	List<messageDetailsEntity> messageDetails = new ArrayList<>();
      	for(messageReceiverEntity entity : receiverData)
      	{
      		messageEntity messEntity = messService.getMessage(entity.getMessage_id());
      		String userName = messEntity.getUser_name();
      		Long id = loginService.getLogin(userName).getAccountId();
      		String email = accountService.getAccount(id).getEmail();

      		messageDetailsEntity messageDetail = messageDetailsEntity.toEntity(messEntity, entity);	
      		messageDetail.setSenderEmail(email);
      		messageDetails.add(messageDetail);
      	}
    	return new ResponseEntity<Iterable<messageDetailsEntity>>(messageDetails, HttpStatus.OK);
    	
	}
    
    
    //Delete Message
//    @RequestMapping(value = "/sent", method = RequestMethod.GET)
//	public @ResponseBody String  getSentMessage() {
//    	LoginEntity login = this.getLoginEntity();
//    	List<messageEntity> messages = messService.getMessageByUserName(login.getUserName());
//    	//return new ResponseEntity<Iterable<messageEntity>>(messages, HttpStatus.OK);
//    	return "Test";
//    	
//	}
    
    
    @RequestMapping(value = "/ReceiverDelete/{ids}", method = RequestMethod.GET)
	public ResponseEntity<?>  deleteReceiverMessage(@PathVariable("ids") String messageIds) {
    	AccountEntity account = this.getCurrentAccout();
    	List<String> idList = Arrays.asList(messageIds.split(","));
    	for(String id : idList)
    	{
    		Long idLong = null;
    		idLong = idLong.valueOf(id);
    		messageReceiverEntity messageData = messReceiverService.findById(idLong, account.getEmail());
        	messageData.setMessage_flags(messageReceiverEntity.messageFlag.delete);
        	messReceiverService.update(messageData);
    	}
   	
        return new ResponseEntity<>(account, HttpStatus.OK);

	}
    
    @GetMapping("/")
	public @ResponseBody String test()
	{
		return "This is a test";
	}

    
    //Add Message
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public ResponseEntity<?> addMessage(@RequestBody MessageFormDto messageDto)
	{
		LoginEntity account = this.getLoginEntity();
		
		if (account == null)
		{
			return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
		}
		List<String> receiverEmails = messageDto.getEmail();
		messageEntity messEntity = new messageEntity();
		messEntity.setUser_name(account.getUserName());
		messEntity.setSubject(messageDto.getSubjectText());
		messEntity.setMessage(messageDto.getMessageText());
		messEntity.setSend_date(new Date());
		messEntity.setDeleted(false);
		messEntity.setId((long)messService.getAllMessage().size()+1);
		messService.addMessage(messEntity);
		
		
		List<messageReceiverEntity> receiverEntities;
		for(String email : receiverEmails)
		{
			messageReceiverEntity entity = new messageReceiverEntity(messEntity.getId(), email, messageReceiverEntity.messageFlag.not_read);
			messReceiverService.addMessageReceiver(entity);
		}
        return new ResponseEntity<>(messEntity, HttpStatus.OK);

	}
	
//	 @GetMapping("/authenticatedAccount")
	    @RequestMapping(value="/authenticatedAccount" ,method = RequestMethod.GET)

	    public ResponseEntity<?> getAuthenticatedAccount() {
	    	String authenticatedUserName = "";
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
	    		authenticatedUserName = authentication.getName();
	    	}
	    	
	    	LoginEntity login = loginService.getLogin(authenticatedUserName);
	    	
	    	if (login == null) {
	    		return new ResponseEntity(new RuntimeException("Autheticated login not found"), HttpStatus.NOT_FOUND);
	    	} else {
		        AccountEntity account = accountService.getAccount(login.getAccountId());
		        if (account == null) {
		            return new ResponseEntity(new RuntimeException("Account with id " + login.getAccountId() 
		                    + " not found"), HttpStatus.NOT_FOUND);
		        }
		        return new ResponseEntity<AccountEntity>(account, HttpStatus.OK);
	    	}
	    }
	
	

	

    
    
   

}
