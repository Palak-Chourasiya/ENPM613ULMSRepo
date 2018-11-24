package ulms.login.exceptions;

import ulms.entity.exceptions.EntityNotFoundException;

/**
 * Exception thrown when requesting a non existent (or no-longer existent) ingredient.
 */
@SuppressWarnings("serial")
public class LoginNotFoundException extends EntityNotFoundException {

    public LoginNotFoundException(String username) {
        super("Could not find login username " + username);
    }
}