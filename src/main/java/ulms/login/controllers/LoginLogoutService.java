package ulms.login.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.login.exceptions.AccountNotFoundException;
import ulms.login.exceptions.LoginNotFoundException;
import ulms.login.models.AccountEntity;
import ulms.login.models.AccountRepository;
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

    public LoginEntity getAccount(String userName) {
        Optional<LoginEntity> login = loginRepository.findById(userName);
        if (!login.isPresent()) {
            throw new LoginNotFoundException(userName);
        }
        
        return login.get();
    }
    
    public Iterable<LoginEntity> getAllLogins() {
        return loginRepository.findAll();
    }
    
    public void addLogin(LoginEntity newLogin) {
        loginRepository.save(newLogin);
    }
}