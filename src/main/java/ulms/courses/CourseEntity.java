package ulms.courses;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ulms.courses.modules.CourseModuleEntity;
import ulms.students.ParticipantsEntity;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "course")
public class CourseEntity implements Serializable {
	@Id
	@Column(name="id", unique = true)
	@NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="details", nullable=false)
	private String details;
	
	@Column(name="instructor_id", nullable=false)
	private Long instructor_id;
	
	@Column(name="start_date", nullable=false)
	private Date start_date;
	
	public Long getInstructor_id() {
		return instructor_id;
	}


	public void setInstructor_id(Long instructor_id) {
		this.instructor_id = instructor_id;
	}


	public Date getStart_date() {
		return start_date;
	}


	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}


	public Date getEnd_date() {
		return end_date;
	}


	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}


	public Set<CourseModuleEntity> getModule() {
		return module;
	}


	public void setModule(Set<CourseModuleEntity> module) {
		this.module = module;
	}


	public void setParticipantEntity(Set<ParticipantsEntity> participantEntity) {
		this.participantEntity = participantEntity;
	}

	@Column(name="end_date", nullable=false)
	private Date end_date;
	
	@Column(name="syllabus_link") 
	private String syllabus;
	
	@OneToMany(mappedBy = "course")
	@JsonIgnore
    private Set<ParticipantsEntity> participantEntity;

    public Set<ParticipantsEntity> getParticipantEntity() {
		return participantEntity;
	}
	
    @OneToMany(mappedBy="course")
    @JsonIgnore
    private Set<CourseModuleEntity> module;


    public Set<CourseModuleEntity> getModuleEntity() {
		return module;
	}
	
    
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDetails() {
		return this.details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
	
	public Long getInstructorId() {
		return this.instructor_id;
	}
	
	public void setInstructorId(Long instructor_id) {
		this.instructor_id  = instructor_id;
	}
	
	public String getSyllabus() {
		return this.syllabus;
	}

	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	
	/*
	public ZonedDateTime getStartDate() {
		return this.start_date;
	}
	
	public void setStartDate(String start_date) {
		String formatted = "";
		if (start_date.length() == 8) {
			formatted = LocalDate.parse(start_date, DateTimeFormatter.ofPattern("MM/dd/yy")).format(DateTimeFormatter.ISO_LOCAL_DATE);
		} else if (start_date.length() == 10) {
			formatted = LocalDate.parse(start_date, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(DateTimeFormatter.ISO_LOCAL_DATE);
		}
		
		this.start_date  = ZonedDateTime.parse(formatted + "T" + LocalTime.now() + "Z[UTC]", DateTimeFormatter.ISO_ZONED_DATE_TIME);
	}
	
	public ZonedDateTime getEndDate() {
		return this.end_date;
	}
	
	public void setEndDate(String end_date) {
		String formatted = "";
		if (end_date.length() == 8) {
			formatted = LocalDate.parse(end_date, DateTimeFormatter.ofPattern("MM/dd/yy")).format(DateTimeFormatter.ISO_LOCAL_DATE);
		} else if (end_date.length() == 10) {
			formatted = LocalDate.parse(end_date, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(DateTimeFormatter.ISO_LOCAL_DATE);
		}
		
		this.end_date  = ZonedDateTime.parse(formatted + "T" + LocalTime.now() + "Z[UTC]", DateTimeFormatter.ISO_ZONED_DATE_TIME);
	}
	*/

}