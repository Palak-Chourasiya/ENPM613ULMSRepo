package ulms.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("repo1")
@Transactional(readOnly = true)
public interface ParticipantsRepository extends JpaRepository<ParticipantsEntity,Long> {


}
