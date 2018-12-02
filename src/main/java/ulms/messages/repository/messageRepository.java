package ulms.messages.repository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ulms.messages.model.entity.messageEntity;

@Repository
@Transactional(readOnly = true)
public interface messageRepository extends JpaRepository<messageEntity, Long> {

}
