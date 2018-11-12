package ulms.students;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.login.AccountEntity;
import ulms.login.AccountRepository;


@Service
public class StudentEnrollmentService {
	 public static final String CACHE_NAME = "cache.account";
	 public static final Class CACHE_TYPE = AccountEntity.class;
	 public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";
	
	 
	 private final AccountRepository accountRepository;
	
	  @Autowired
	    public StudentEnrollmentService(AccountRepository accountRepository) {
	        this.accountRepository = accountRepository;
	    }


	    public AccountEntity getStudentList(Long studentId) {
	        Optional<AccountEntity> student = accountRepository.findById(studentId);
	        return student.get();
	    }
}
