package messages;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/message")
public class messageController {
	
	@Autowired
	messageService messService;
	
	@PostMapping("/add")
	public ResponseEntity<?> sendMessage(@RequestBody messageEntity message, org.springframework.web.util.UriComponentsBuilder uriBuilder)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriBuilder.path("message/{id}").buildAndExpand(message.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}
