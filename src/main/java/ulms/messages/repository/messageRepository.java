package ulms.messages.repository;


import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ulms.messages.model.entity.messageEntity;
import ulms.messages.model.entity.messageReceiverEntity;

@Repository
@Transactional(readOnly = true)
public interface messageRepository extends JpaRepository<messageEntity, Long> {
	@Query("select u from messageEntity u where u.user_name = ?1")
	List<messageEntity> findByUserName(String userName);

}
