package org.koreait.board.exceptions;

import org.koreait.global.exceptions.CommonException;
import org.springframework.http.HttpStatus;

public class CommentNotFoundException extends CommonException {
    public CommentNotFoundException() {
        super("NotFound", HttpStatus.NOT_FOUND);
        setErrorCode(true);
    }
}
