package ulms.courses.modules;

import java.io.Serializable;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ulms.courses.CourseEntity;
import ulms.students.ParticipantsEntity;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "module")
public class CourseModuleEntity implements Serializable {
	@Id
	@Column(name="module_number", unique = true)
	@NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long module_number;
	
	public Long getModule_number() {
		return module_number;
	}
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="course_id",insertable=false, updatable=false)
    private CourseEntity course;

    @Column(name="course_id", nullable=false)
	private Long course_id;
	
	@Column(name="title", nullable=false)
	private String title;

	
	@Column(name="date_published", nullable=false)
	private ZonedDateTime date_published;

	public void setModule_number(Long module_number) {
		this.module_number = module_number;
	}

	public Long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Long course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ZonedDateTime getDate_published() {
		return date_published;
	}

	public void setDate_published(ZonedDateTime date_published) {
		this.date_published = date_published;
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
