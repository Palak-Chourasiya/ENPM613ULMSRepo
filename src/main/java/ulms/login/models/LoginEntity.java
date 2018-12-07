package ulms.login.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "login")
public class LoginEntity {
    @Id
	@Column(name="user_name", unique = true)
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String userName;
   
    @NotNull
    @NotEmpty
    @Column(name="account_id", nullable=false)
    private Long accountId;
    
    @NotNull
	@NotEmpty
    @Column(name="password", nullable=false)
    private String password;
    
    @OneToOne
    @JoinColumn(name="account_id", insertable=false, updatable=false, referencedColumnName="id")
    private AccountEntity account;
    
    public String getUserName() {
    	return this.userName;
	}
	
    public void setUserName(String userName) {
    	this.userName = userName;
	}
	
    public Long getAccountId() {
    	return this.accountId;
	}
	
    public void setAccountId(Long accountId) {
    	this.accountId = accountId;
	}
    
    public String getPassword() {
		return this.password;
	}
		
	public void setPassword(String password) {
		this.password = password;
	}
	
	public AccountEntity getAccount() {
		return this.account;
	}
	public LoginEntity()
	{
		
	}
}
