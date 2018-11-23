package ulms.login.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("repo2")
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<AccountEntity,Long>{

}
