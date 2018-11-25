package ulms.courses.modules;

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
public class CourseModuleManagementService {
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
    public Iterable<CourseModuleEntity> getAllCourseModules() {
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
	 
	 public void addModule(CourseModuleEntity courseModule) {
			courseModuleRepository.save(courseModule);
		}
	 
	 public void deleteModule(Long module_number) {
		 	courseModuleRepository.deleteById(module_number);
		}
	 
}