package sopt.org.FourthSeminar.exception.model;

import sopt.org.FourthSeminar.exception.Error;

public class BadRequestException extends SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
