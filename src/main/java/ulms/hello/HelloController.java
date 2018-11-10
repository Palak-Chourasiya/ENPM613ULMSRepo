package ulms.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/hello")
public class HelloController {
	@GetMapping("/")
	public ResponseEntity<String> index() {
	    return new ResponseEntity<>("Hello World!", HttpStatus.OK);
	}
}
