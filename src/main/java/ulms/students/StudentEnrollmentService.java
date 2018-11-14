package ulms.students;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ulms.login.AccountEntity;
import ulms.login.AccountRepository;
import antlr.collections.List;



@Service
public class StudentEnrollmentService {
	 public static final String CACHE_NAME = "cache.account";
	 public static final Class CACHE_TYPE = AccountEntity.class;
	 public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";
	
	 @Autowired
	 @Qualifier("repo2")
	 private final AccountRepository accountRepository;
	 @Autowired
	 @Qualifier("repo1")
	 private final ParticipantsRepository participantsRepository;
	 
	  @Autowired
	    public StudentEnrollmentService(AccountRepository accountRepository,ParticipantsRepository participantsRepository ) {
	        this.accountRepository = accountRepository;
	        this.participantsRepository = participantsRepository; 
	    }

	  public AccountEntity getStudentDetails(Long accountId) {
	        Optional<AccountEntity> student = accountRepository.findById(accountId);
	        return student.get();
	    }
	  
	  public java.util.List<AccountEntity> getStudentList() {
	        return accountRepository.findAll();
	    }
	  public java.util.List<ParticipantsEntity> getAccountId() {
	        return participantsRepository.findAll();
	    }
	  /*public ParticipantsEntity getAccountId(Long course_id) {
	        Optional<ParticipantsEntity> participant = participantsRepository.findById(course_id);
	        return participant.get();
	    }*/
	  
}


