package ulms.courses.modules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ModuleRepository extends JpaRepository<CourseModuleEntity, Long> {
	
}
