package ulms.messages.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ulms.messages.model.entity.messageReceiverEntity;
import ulms.messages.model.entity.messageReceiverEntity.messageFlag;
import ulms.messages.model.entity.messageReceiverIdentity;

@Repository
@Transactional(readOnly = true)
public interface messageReceiverRepository extends JpaRepository<messageReceiverEntity, messageReceiverIdentity>{
	
	@Query("select u from messageReceiverEntity u where u.email = '?1'")
	List<messageReceiverEntity> findByEmail(String email);
	
	@Query("select u from messageReceiverEntity u where u.email = ?1 and u.message_flag = 'read'")
	List<messageReceiverEntity> findReadEmail(String email);
	
	@Query("select u from messageReceiverEntity u where u.email = ?1 and u.message_flag = 'not_read'")
	List<messageReceiverEntity> findUnReadEmail(String email);
	
	@Query("select u from messageReceiverEntity u where u.email = ?1 and u.message_flag = 'delete'")
	List<messageReceiverEntity> findDeleteEmail(String email);
	
	
	@Query("select u from messageReceiverEntity u where u.email = '?1' and u.message_flag = '?2'")
	List<messageReceiverEntity> findAllEmail(String email, String flag);
}
