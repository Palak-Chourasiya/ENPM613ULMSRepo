package ulms.login.controllers;

import ulms.login.models.LoginEntity;

public interface ILoginLogoutService {
	public LoginEntity getLogin(String username);
    
    public Iterable<LoginEntity> getAllLogins();
    
    public void addLogin(LoginEntity newLogin);
}
