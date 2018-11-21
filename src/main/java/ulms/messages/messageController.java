package ulms.messages;


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
import org.springframework.web.bind.annotation.ResponseBody;
import ulms.messages.messageEntity;

@Controller
@RequestMapping(path="/messageTest")
public class messageController {
	
	@Autowired
	MessageService messService;
	
	@GetMapping("/")
    public @ResponseBody String index() {
    	
        return "TEST";
    }
	
	/*
	@PostMapping("/add")
	public ResponseEntity<?> sendMessage(@RequestBody messageEntity message, org.springframework.web.util.UriComponentsBuilder uriBuilder)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriBuilder.path("message/{id}").buildAndExpand(message.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	 @GetMapping("/{id}")
	    public ResponseEntity<?> getMessageDetails(@PathVariable("id") long messageId) {
		messageEntity messagetData = messService.getMessage(messageId);
		if(messagetData==null) {
	     return new ResponseEntity(new RuntimeException("Message with id "+messageId+" not found"), HttpStatus.NOT_FOUND);
		}
	     return new ResponseEntity<messageEntity>(messagetData, HttpStatus.OK);

	 }
	 */
	

}
