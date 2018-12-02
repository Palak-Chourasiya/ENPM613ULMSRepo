package ulms.login.controllers;

import java.security.Principal;
import java.util.Base64;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@GetMapping("/login")
    public String login(HttpServletRequest request) {
		return "login";
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
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	
	/*
	@GetMapping("/logout")
    public ResponseEntity<?> logout() {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
    }
	
	@PostMapping("/logout")
    public ResponseEntity<?> submitLogout() {
    	return new ResponseEntity<Iterable<LoginEntity>>(loginService.getAllLogins(), HttpStatus.OK);
    }
    */
}
