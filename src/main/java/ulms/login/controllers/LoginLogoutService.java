package ulms.login.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulms.login.models.AccountEntity;
import ulms.login.models.LoginEntity;
import ulms.login.models.LoginRepository;

/**
 * Service providing high-level, selectively cached data access and other {@link AccountEntity}
 * -related operations.
 */
@Service
public class LoginLogoutService implements UserLoginLogoutServiceInterface {
    public static final String CACHE_NAME = "cache.login";
    public static final Class CACHE_TYPE = AccountEntity.class;
    public static final String CACHE_TTL = "${cache.login.timetolive:60}";

    private final LoginRepository loginRepository;

    @Autowired
    public LoginLogoutService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    // Property methods

    // Query methods

    public LoginEntity getLogin(String userName) {
        Optional<LoginEntity> login = loginRepository.findById(userName);
        if (!login.isPresent()) {
        	return null;
        }
        
        return login.get();
    }
    
    public Iterable<LoginEntity> getAllLogins() {
        return loginRepository.findAll();
    }
    
    public void addLogin(LoginEntity newLogin) {
        loginRepository.save(newLogin);
    }

	@Override
	public LoginEntity getAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}