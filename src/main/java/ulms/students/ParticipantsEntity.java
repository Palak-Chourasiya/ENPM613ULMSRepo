package ulms.students;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ulms.courses.CourseEntity;
import ulms.login.models.AccountEntity;
import ulms.recipes.models.IngredientEntity;
import ulms.recipes.models.RecipeEntity;
import ulms.recipes.models.RecipeIngredientsIdentity;


@Entity
@Table(name = "participants")
@IdClass(ParticipantIdentity.class)
public class ParticipantsEntity {
	
			@Id
		    @NotNull
		    private Long course_id;
			
			@Id
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
		    
			@ManyToOne
			@JsonIgnore
			@JoinColumn(name="account_id", insertable=false, updatable=false, referencedColumnName="id")
			private AccountEntity account;
			
			@ManyToOne
			@JsonIgnore
		    @JoinColumn(name="course_id", insertable=false, updatable=false, referencedColumnName="id")
		    private CourseEntity course;

}
