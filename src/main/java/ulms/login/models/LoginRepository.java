package ulms.login.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface LoginRepository extends JpaRepository<LoginEntity,String>{

}
