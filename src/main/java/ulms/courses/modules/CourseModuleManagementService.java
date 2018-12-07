package ulms.courses.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.courses.CourseRepository;
import ulms.recipes.models.RecipeEntity;

/**
 * Service providing high-level, selectively cached data access and other {@link RecipeEntity}
 * -related operations.
 */
@Service
public class CourseModuleManagementService implements CourseModuleManagementServiceInterface{
    public static final String CACHE_NAME = "cache.recipe";
    public static final Class<CourseModuleEntity> CACHE_TYPE = CourseModuleEntity.class;
    public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";


    private final CourseModuleRepository courseModuleRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public CourseModuleManagementService(CourseModuleRepository courseModuleRepository, CourseRepository courseRepository) {
        this.courseModuleRepository = courseModuleRepository;
        this.courseRepository = courseRepository; 
    }
    /**
     * 
     * @return Fetches the modules of all courses 
     */
    public List<CourseModuleEntity> getAllCourseModules() {
        return courseModuleRepository.findAll();
    }
    /**
     * 
     * @return Fetches one module 
     */
	 public CourseModuleEntity getModuleDetails(Long module_number) {
	        Optional<CourseModuleEntity> module = courseModuleRepository.findById(module_number);
	        return module.get();
	    }
	 
	//creates a new course module
	 public void addModule(CourseModuleEntity courseModule) {
			courseModuleRepository.save(courseModule);
		}
	 
	//creates a new course module
	 public void deleteModule(Long module_number) {
		 	courseModuleRepository.deleteById(module_number);
		}
	 
	 // if course module already exist in the Db, update
	 public void updateModule(CourseModuleEntity updateEntity) {
		 courseModuleRepository.save(updateEntity);
	 }
	 
	public Iterable<CourseModuleEntity> getModulesforCourse(long course_id) {
		List<CourseModuleEntity> modules= new ArrayList<CourseModuleEntity>();
		try {
		 modules= getAllCourseModules();
		}catch(Exception e) {
			System.out.println(e+ "exception caught");
		}
		List<CourseModuleEntity> modulesforcourse= new ArrayList<CourseModuleEntity>();
		
		try {
			for(CourseModuleEntity module:modules) {
				if(course_id==module.getCourseId()) {
					modulesforcourse.add(module);
				}
			}
			}catch(Exception e) {
				System.out.println(e+ "exception caught");
			}
		return modulesforcourse;
	}
}