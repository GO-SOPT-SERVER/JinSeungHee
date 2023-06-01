package sopt.org.FourthSeminar.exception.model;

import sopt.org.FourthSeminar.exception.Error;

public class UnauthorizedException extends SoptException {
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
