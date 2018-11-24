package ulms.login.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ulms.recipes.models.RecipeEntity;
import ulms.recipes.models.RecipeIngredientsIdentity;

@Entity
@Table(name = "rolepermissions")
@IdClass(RolePermissionsIdentity.class)
public class RolePermissionsEntity {
	@Id
	@NotNull
	@Column(name="role_id", nullable=false)
	private Long roleId;
	
	@Id
	@NotNull
	@Column(name="permission_id", nullable=false)
	private Long permissionId;
	
	@ManyToOne
	@JoinColumn(name="role_id", insertable=false, updatable=false, referencedColumnName="id")
	@JsonIgnore
	private RoleEntity role;
	
	@ManyToOne
	@JoinColumn(name="permission_id", insertable=false, updatable=false, referencedColumnName="id")
	private PermissionEntity permission;
	
	public Long getRoleId() {
    	return this.roleId;
    }
    
    public Long getPermissionId() {
    	return this.permissionId;
    }
    
    public PermissionEntity getPermission() {
    	return this.permission;
    }
}
