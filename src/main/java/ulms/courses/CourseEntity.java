package ulms.courses;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import ulms.courses.modules.CourseModuleEntity;
import ulms.students.ParticipantsEntity;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "course")
public class CourseEntity {
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
	
	/*
	@Column(name="start_date", nullable=false)
	private ZonedDateTime start_date;
	
	@Column(name="end_date", nullable=false)
	private ZonedDateTime end_date;
	*/
	
	@OneToMany(mappedBy = "course")
    private Set<ParticipantsEntity> participantEntity;

    public Set<ParticipantsEntity> getParticipantEntity() {
		return participantEntity;
	}
	
    /*
    @OneToMany(mappedBy = "module")
    @ManyToOne()
	@PrimaryKeyJoinColumn(name="id", referencedColumnName="course_id")
    private Set<CourseModuleEntity> moduleEntity;

    public Set<CourseModuleEntity> getModuleEntity() {
		return moduleEntity;
	}
	*/
    
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
