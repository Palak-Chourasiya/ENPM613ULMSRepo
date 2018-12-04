package ulms.courses;

public interface CourseManagementServiceInterface {
	public CourseEntity getCourse(Long courseId);
	 public Iterable<CourseEntity> getAllCourses();
}
