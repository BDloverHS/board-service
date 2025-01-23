package org.port.board.exceptions;

import org.port.global.exceptions.BadRequestException;

public class GuestPasswordCheckException extends BadRequestException {
    public GuestPasswordCheckException() {
        super("Required.guestPassword");
        setErrorCode(true);
    }
}
