package ulms.courses.modules;

import java.util.List;

public interface CourseModuleManagementServiceInterface {
	 public List<CourseModuleEntity> getAllCourseModules();
	 public CourseModuleEntity getModuleDetails(Long module_number);
	 public void addModule(CourseModuleEntity courseModule);
	 public void deleteModule(Long module_number);
	 public void updateModule(CourseModuleEntity updateEntity);
	 public Iterable<CourseModuleEntity> getModulesforCourse(long course_id) ;
}
