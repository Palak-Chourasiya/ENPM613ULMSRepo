package ulms.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ulms.login.models.AccountEntity;
import ulms.login.models.LoginEntity;

@Controller
@RequestMapping(path="/accounts")
public class AccountController {

	@Autowired
	//Service which will do account data retrieval/manipulation work
    IAccountService accountService; 
	
	@Autowired
	//Service which will do login based data retrieval/manipulation work
	UserLoginLogoutServiceInterface loginService; 
	/*
	 * returns the details of all the accounts 
	 */
    @GetMapping("/")
    public ResponseEntity<?> getAllAccounts() {
    	return new ResponseEntity<Iterable<AccountEntity>>(accountService.getAllAccounts(), HttpStatus.OK);
    }
    /**
     * 
     * @param accountId
     * @return Details of the account id passed 
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<?> getAccount(@PathVariable("accountId") long accountId) {
        AccountEntity account = accountService.getAccount(accountId);
        if (account == null) {
            return new ResponseEntity(new RuntimeException("Account with id " + accountId 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AccountEntity>(account, HttpStatus.OK);
    }
/**
 * 
 * @return Details of the logged in user
 */
    @GetMapping("/authenticatedAccount")
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
