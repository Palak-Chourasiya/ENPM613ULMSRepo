package ulms.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ulms.login.models.AccountEntity;

@Controller
@RequestMapping(path="/accounts")
public class AccountController {

	@Autowired
    IAccountService accountService; //Service which will do all data retrieval/manipulation work
	
    @GetMapping("/")
    public ResponseEntity<?> index() {
    	return new ResponseEntity<Iterable<AccountEntity>>(accountService.getAllAccounts(), HttpStatus.OK);
    }
    
    /*
    public @ResponseBody String index() {
    	
    	Course course = new Course();
    	course.setTitle("");
    	course.setInstructorId(1);
    	course.setStartDate(ZonedDateTime.parse(formatted + "T" + LocalTime.now() + "-04:00[America/New_York]", DateTimeFormatter.ISO_ZONED_DATE_TIME));
    	course.setEndDate(ZonedDateTime.parse(formatted + "T" + LocalTime.now() + "-04:00[America/New_York]", DateTimeFormatter.ISO_ZONED_DATE_TIME));
    	
    	model.addAttribute("", course.getTitle());
    	model.addAttribute("", course.getInstructorId());
    	model.addAttribute("", course.getStartDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
    	model.addAttribute("", course.getEndDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
    	
        return "TEST";
    }
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

}
