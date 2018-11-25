package ulms.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ulms.login.models.AccountEntity;
import ulms.login.models.AccountRepository;


@Service
public class StudentEnrollmentService {
	 public static final String CACHE_NAME = "cache.account";
	 public static final Class CACHE_TYPE = AccountEntity.class;
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

	    public AccountEntity getStudentDetails(Long studentId) {
	        Optional<AccountEntity> student = accountRepository.findById(studentId);
	        return student.get();
	    }
	  
	    /**
	     * 
	     * @return List of Students with their account details
	     */
	  public Iterable<AccountEntity> getStudentList() {
		  Iterable<AccountEntity> participantList =  accountRepository.findAll();
		  
		  return filterStudents(participantList);
	    }
	  
	  /**
	     * 
	     * @return List of Instructors with their account details
	     */
	  public Iterable<AccountEntity> getInstructorList() {
		  Iterable<AccountEntity> participantList =  accountRepository.findAll();
		  
		  return filterInstructors(participantList);
	    }
	  
	  
	  /**
	   * 
	   * @param participantList
	   * @return List of Student accounts
	   */
	  private Iterable<AccountEntity> filterStudents( Iterable<AccountEntity> participantList){
		  List<AccountEntity> resultList =new ArrayList<AccountEntity>();	  
		  int roleID =2;
		  for (AccountEntity oneStudent: participantList) {
			  if(roleID==oneStudent.getRoleId()) {
				  resultList.add(oneStudent);
			  }
		  }		  
	      
		  return resultList;
	  }
	  
	  /**
	   * 
	   * @param participantList
	   * @return List of Instructor accounts
	   */
	  private Iterable<AccountEntity> filterInstructors( Iterable<AccountEntity> participantList){
		  List<AccountEntity> resultList = new ArrayList<AccountEntity>();	  
		  int roleID =1;
		  for (AccountEntity oneStudent: participantList) {
			  if(roleID==oneStudent.getRoleId()) {
				  resultList.add(oneStudent);
			  }
		  }		  
	      
		  return resultList;
	  }
	  
	  /**
	   * @param course_id
	   * @return All the Students will account details for a course based on course_id
	   */
	  public Iterable<AccountEntity> getAllParticipantsInCourse(Long course_id) {
		  Iterable<ParticipantsEntity> resultList =participantsRepository.findAll();
		  List<ParticipantsEntity> participants= new ArrayList<ParticipantsEntity>();
		  for (ParticipantsEntity oneParticipant: resultList) {
			  if(course_id==oneParticipant.getcourse_id()) {
				  participants.add(oneParticipant);
			  }
		  }		  
		  List<AccountEntity> oneCourseParticipants= new ArrayList<AccountEntity>();
		  for (ParticipantsEntity oneParticipant: participants) {
			  oneCourseParticipants.add(getStudentDetails(oneParticipant.getAccount_id()));
		  }  
		  return filterStudents(oneCourseParticipants);
	  }
	  
	  public List<ParticipantsEntity> getAllParticipants() {
	  return participantsRepository.findAll();
	  }
}



