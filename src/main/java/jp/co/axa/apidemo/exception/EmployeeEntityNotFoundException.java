package jp.co.axa.apidemo.exception;

import lombok.Getter;

import javax.persistence.EntityNotFoundException;
@Getter
public class EmployeeEntityNotFoundException extends EntityNotFoundException{

    private final String detailedMessage;
    public EmployeeEntityNotFoundException(String message, String detailedMessage) {
        super(message);
        this.detailedMessage = detailedMessage;
    }

}
