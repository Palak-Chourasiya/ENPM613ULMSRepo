package ulms.login.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ulms.messages.model.entity.messageReceiverEntity;

@Repository
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<AccountEntity,Long>{
	@Query("select u from #{#entityName} u where u.email = ?1")
	List<AccountEntity> findByEmail(String email);

}
