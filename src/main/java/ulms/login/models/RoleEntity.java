package ulms.login.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class RoleEntity {
	@Id
	@Column(unique = true)
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	@NotNull
    @NotEmpty
    @Column(name="role", nullable=false)
    private String role;
	
	@OneToMany(mappedBy = "role")
    private List<AccountEntity> roleAccount;
	
	@OneToMany(mappedBy = "role")
    private List<RolePermissionsEntity> rolePermissions;
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
