package ulms.login.controllers;

import ulms.login.models.AccountEntity;

public interface IAccountService {
	public AccountEntity getAccount(Long accountId);
    
    public Iterable<AccountEntity> getAllAccounts();
    
    public void addRecipe(AccountEntity newAccount);
}
