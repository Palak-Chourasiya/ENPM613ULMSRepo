package ulms.login.controllers;

import ulms.login.models.LoginEntity;

public interface UserLoginLogoutServiceInterface {
	public LoginEntity getAccount(String username);
    
    public Iterable<LoginEntity> getAllLogins();
    
    public void addLogin(LoginEntity newLogin);

	public LoginEntity getLogin(String userName);
}
