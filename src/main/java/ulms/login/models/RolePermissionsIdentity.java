package ulms.login.models;

import java.io.Serializable;

import ulms.recipes.models.RecipeIngredientsIdentity;

public class RolePermissionsIdentity implements Serializable {
	private Long roleId;

    private Long permissionId;

    public RolePermissionsIdentity() {

    }

    public RolePermissionsIdentity(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    public Long getPermissionId() {
        return this.permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		RolePermissionsIdentity that = (RolePermissionsIdentity) obj;
		
		if (this.roleId == null) {
			if (that.roleId != null) return false;
		} else if (!this.roleId.equals(that.roleId)) return false;
		
		if (this.permissionId == null) {
			if (that.permissionId != null) return false;
		} else if (!this.permissionId.equals(that.permissionId)) return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.roleId == null) ? 0 : this.roleId.hashCode());
		result = prime * result + ((this.permissionId == null) ? 0 : this.permissionId.hashCode());
		return result;
	}
}
