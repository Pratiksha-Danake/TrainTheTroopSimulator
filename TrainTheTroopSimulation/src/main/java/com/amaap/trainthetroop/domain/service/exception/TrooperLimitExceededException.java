package com.amaap.trainthetroop.domain.service.exception;

public class TrooperLimitExceededException extends Throwable {
    public TrooperLimitExceededException(String message) {
        super(message);
    }
}
