package ulms.login.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
	@Column(unique = true)
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
   
    @NotNull
    @NotEmpty
    @Column(name="role_id", nullable=false)
    private Long roleId;
    
    @NotNull
	@NotEmpty
    @Column(name="first_name", nullable=false)
    private String firstName;
 
    @NotNull
    @NotEmpty
    @Column(name="last_name", nullable=false)
    private String lastName;
    
    @NotNull
    @NotEmpty
    @Column(name="email", nullable=false)
    private String email;
    
    /*
    @OneToOne
    @JoinColumn(name="id", insertable=false, updatable=false, referencedColumnName="account_id")
    @JsonIgnore
    private LoginEntity login;
    */
    
    @ManyToOne
    @JoinColumn(name="role_id", insertable=false, updatable=false, referencedColumnName="id")
    private RoleEntity role;
    
    public Long getId() {
    	return this.id;
	}
	
    public void setId(Long id) {
    	this.id = id;
	}
	
    public Long getRoleId() {
    	return this.roleId;
	}
	
    public void setRoleId(Long roleId) {
    	this.roleId = roleId;
	}
		
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public RoleEntity getRole() {
		return this.role;
	}
}
