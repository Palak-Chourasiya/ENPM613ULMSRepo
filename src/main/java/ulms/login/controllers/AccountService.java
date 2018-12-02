package ulms.login.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.login.exceptions.AccountNotFoundException;
import ulms.login.models.AccountEntity;
import ulms.login.models.AccountRepository;
import ulms.messages.model.entity.messageReceiverEntity;

/**
 * Service providing high-level, selectively cached data access and other {@link AccountEntity}
 * -related operations.
 */
@Service
public class AccountService implements IAccountService {
    public static final String CACHE_NAME = "cache.account";
    public static final Class CACHE_TYPE = AccountEntity.class;
    public static final String CACHE_TTL = "${cache.account.timetolive:60}";

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Property methods

    // Query methods

    public AccountEntity getAccount(Long accountId) {
        Optional<AccountEntity> account = accountRepository.findById(accountId);
        if (!account.isPresent()) {
            return null;
        }
        return account.get();
    }
    
    public Iterable<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }
    
    public void addAccount(AccountEntity newAccount) {
        accountRepository.save(newAccount);
    }
    
	public AccountEntity getMessageByEmail(String email)
	{
		List<AccountEntity> accounts = new ArrayList<>();
		accounts = accountRepository.findByEmail(email);
		if (accounts.size() != 1)
			return null;
		return accounts.get(0);
	}
}