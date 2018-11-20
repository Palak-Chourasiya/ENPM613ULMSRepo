package ulms.courses;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.recipes.exceptions.RecipeNotFoundException;
import ulms.recipes.models.IngredientRepository;
import ulms.recipes.models.RecipeDTO;
import ulms.recipes.models.RecipeEntity;
import ulms.recipes.models.RecipeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Service providing high-level, selectively cached data access and other {@link RecipeEntity}
 * -related operations.
 */
@Service
public class CourseService {
    public static final String CACHE_NAME = "cache.recipe";
    public static final Class<CourseEntity> CACHE_TYPE = CourseEntity.class;
    public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";


    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Property methods

    // Query methods

    public CourseEntity getCourse(Long courseId) {
        Optional<CourseEntity> course = courseRepository.findById(courseId);
        if (!course.isPresent()) {
            throw new CourseNotFoundException(courseId);
        }
        
        
        return course.get();
    }
    
    public Page<CourseEntity> getAllCourses(Pageable pageRequest) {
        return courseRepository.findAll(pageRequest);
    }
    
    public void addCourse(CourseEntity newCourse) {
        courseRepository.save(newCourse);
    }
}