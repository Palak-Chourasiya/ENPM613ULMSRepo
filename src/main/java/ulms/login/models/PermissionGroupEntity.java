package ulms.login.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "permissiongroup")
public class PermissionGroupEntity {
	@Id
	@Column(unique = true)
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	@NotNull
    @NotEmpty
    @Column(name="group", nullable=false)
    private String group;
	
	@OneToMany(mappedBy = "group")
	@JsonIgnore
    private List<PermissionEntity> permissionGroup;
	
	public Long getId() {
    	return this.id;
	}
	
    public void setId(Long id) {
    	this.id = id;
	}
	
    public String getGroup() {
		return this.group;
	}
    
	public void setGroup(String group) {
		this.group = group;
	}
}
