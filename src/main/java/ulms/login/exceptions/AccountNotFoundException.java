package ulms.login.exceptions;

import ulms.entity.exceptions.EntityNotFoundException;

/**
 * Exception thrown when requesting a non existent (or no-longer existent) ingredient.
 */
@SuppressWarnings("serial")
public class AccountNotFoundException extends EntityNotFoundException {

    public AccountNotFoundException(long id) {
        super("Could not find account with id " + id);
    }
}