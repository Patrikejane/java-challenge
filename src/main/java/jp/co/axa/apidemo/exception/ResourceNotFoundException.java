package jp.co.axa.apidemo.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException{

    private String detailedMessage;

    public ResourceNotFoundException(String message, String detailedMessage) {
        super(message);
        this.detailedMessage = detailedMessage;
    }

}
