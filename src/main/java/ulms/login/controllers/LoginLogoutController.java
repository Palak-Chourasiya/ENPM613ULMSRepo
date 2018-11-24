package ulms.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ulms.login.models.LoginEntity;

@Controller
@RequestMapping(path="/")
public class LoginLogoutController {
	
	@Autowired
	LoginLogoutService loginService;
	
	@GetMapping("/login")
    public ResponseEntity<?> login(@PathVariable("userName") long userName,
    		                       @PathVariable("password") long password) {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
    }
	
	@GetMapping("/alllogins")
    public ResponseEntity<?> allLogins() {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
    }
	
	@PostMapping("/login")
    public ResponseEntity<?> submitLogin() {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
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
