package ulms.login.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "permission")
public class PermissionEntity {
	@Id
	@Column(unique = true)
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	@NotNull
    @NotEmpty
    @Column(name="permission", nullable=false)
    private String permission;
	
	@NotNull
    @NotEmpty
    @Column(name="group_id", nullable=false)
    private Long groupId;
	
	@OneToMany(mappedBy = "permission")
	@JsonIgnore
    private Set<RolePermissionsEntity> rolePermissions;
	
	@ManyToOne
	@JoinColumn(name="group_id", insertable=false, updatable=false, referencedColumnName="id")
	private PermissionGroupEntity group;
	
	public Long getId() {
    	return this.id;
	}
	
    public void setId(Long id) {
    	this.id = id;
	}
		
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return this.permission;
	}
	
	public Long getGroupId() {
    	return this.groupId;
	}
	
    public void setRoleId(Long groupId) {
    	this.groupId = groupId;
	}
    
    public PermissionGroupEntity getGroup() {
    	return this.group;
    }
}
