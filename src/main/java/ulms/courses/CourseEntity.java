package ulms.courses;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@Column(name="start_date", nullable=false)
	private ZonedDateTime start_date;
	
	@Column(name="end_date", nullable=false)
	private ZonedDateTime end_date;
	
	
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
	
	public ZonedDateTime getStartDate() {
		return this.start_date;
	}
	
	public void setStartDate(ZonedDateTime start_date) {
		this.start_date  = start_date;
	}
	
	public ZonedDateTime getEndDate() {
		return this.end_date;
	}
	
	public void setEndDate(ZonedDateTime end_date) {
		this.end_date  = end_date;
	}

}
