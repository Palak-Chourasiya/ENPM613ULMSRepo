package ulms.login.controllers;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import ulms.login.exceptions.LoginNotFoundException;
import ulms.login.models.LoginEntity;

@Controller
@RequestMapping(path="/")
public class LoginLogoutController {
	
	@Autowired
	UserLoginLogoutServiceInterface loginService;
	
	@RequestMapping("/token")
	@ResponseBody
	public Map<String,String> token(HttpSession session) {
	  return Collections.singletonMap("token", session.getId());
	}
	
	@GetMapping("/login")
	@ResponseBody
    public Principal login(Principal user) {
		return user;
    	//return new ResponseEntity<LoginEntity>(loginService.getLogin(userName), HttpStatus.OK);
    }
	
	@GetMapping("/alllogins")
    public ResponseEntity<?> allLogins() {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
    }
	
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> submitLogin(@RequestBody LoginEntity login) {
		String user = login.getUserName();
    	LoginEntity temp = loginService.getLogin(login.getUserName());
    	
    	if (temp == null) {
    		//Collections.singletonMap("error", "your string value");
    		return new ResponseEntity<String>((new LoginNotFoundException(login.getUserName())).getMessage(), HttpStatus.NOT_FOUND);
    	} else {
    		return new ResponseEntity<String>("Login Successful", HttpStatus.OK);
    	}
    }
	
	@GetMapping("/logout")
    public ResponseEntity<?> logout() {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
    }
	
	@PostMapping("/logout")
    public ResponseEntity<?> submitLogout() {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
    }
}
