package ulms.login.controllers;

import java.security.Principal;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
	
	//@Autowired
	//IAuthenticationService authenticationService;
	@Autowired
	UserLoginLogoutServiceInterface loginService;
	
	@RequestMapping("/token")
	@ResponseBody
	public Map<String,String> token(HttpSession session) {
	  return Collections.singletonMap("token", session.getId());
	}
	
	@RequestMapping("/hasaccess")
	public Principal hasAccess(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
          .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
          .decode(authToken)).split(":")[0];
    }
	
	@RequestMapping("/user")
    public Principal user(Principal user) {
      return user;
    }
	
	@GetMapping("/login")
	@ResponseBody
    public boolean login(HttpServletRequest request) {
		return true;
    	//return new ResponseEntity<LoginEntity>(loginService.getLogin(userName), HttpStatus.OK);
    }
	
	@GetMapping("/alllogins")
    public ResponseEntity<?> allLogins() {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
    }
	
	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public boolean submitLogin(@RequestBody LoginEntity login) {
		//String user = login.getUserName();
    	//LoginEntity temp = loginService.getLogin(login.getUserName());
    	
    	//return authenticationService.verifyLogin(login.getUserName(), login.getPassword());
    	
    	return true;
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
