package ulms.students;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "participants")
public class ParticipantsEntity {
	
			@Id
		    @NotNull
		    private Long course_id;
		   
		    @NotNull
		    private Long account_id;

			public Long getcourse_id() {
				return course_id;
			}

			public void setCourse_id(Long course_id) {
				course_id = course_id;
			}

			public Long getAccount_id() {
				return account_id;
			}

			public void setAccount_id(Long account_id) {
				this.account_id = account_id;
			}
		    
		   

}
