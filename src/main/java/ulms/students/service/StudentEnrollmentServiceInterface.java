package ulms.students.service;

import ulms.login.models.AccountEntity;

public interface StudentEnrollmentServiceInterface {
	public AccountEntity getStudentDetails(Long studentId);
	public Iterable<AccountEntity> getStudentList();
	public Iterable<AccountEntity> getInstructorList();
	public Iterable<AccountEntity> getAllParticipantsInCourse(Long course_id);
}
