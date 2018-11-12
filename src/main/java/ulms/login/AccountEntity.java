package ulms.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



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
	    //@Column(name="RoleId", nullable=false)
	    private Long roleId;
	    
	    @NotNull
		@NotEmpty
	    @Column(name="FirstName", nullable=false)
	    private String firstName;
	 
	    @NotNull
	    @NotEmpty
	    @Column(name="LastName", nullable=false)
	    private String lastName;
	    
	    @NotNull
	    @NotEmpty
	    //@Column(name="Email", nullable=false)
	    private String email;
	    
	    public Long getId() {
				return this.id;
			}
		
	    public void setId(Long id) {
				this.id = id;
			}
		
	    public Long getRoleId() {
				return roleId;
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
	   
}
