package ulms.courses.modules;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.courses.CourseNotFoundException;
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
public class CourseModuleManagementService {
    public static final String CACHE_NAME = "cache.recipe";
    public static final Class<CourseModuleEntity> CACHE_TYPE = CourseModuleEntity.class;
    public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";


    private final ModuleRepository courseRepository;

    @Autowired
    public CourseModuleManagementService(ModuleRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Property methods

    // Query methods

    public CourseModuleEntity getAllModule(Long module_number) {
        Optional<CourseModuleEntity> module = courseRepository.findById(module_number);
        if (!module.isPresent()) {
            throw new CourseModuleNotFoundException(module_number);
        }
        return module.get();
    }
    public Iterable<CourseModuleEntity> getAllModule() {
        return courseRepository.findAll();
    }
    
    //create module in the DB
    public void addModule(CourseModuleEntity newmodule) {
        courseRepository.save(newmodule);
    }
   

}