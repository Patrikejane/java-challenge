package jp.co.axa.apidemo.exception;

import lombok.Getter;
@Getter
public class BadRequestException extends RuntimeException{

        private String detailedMessage;


        public BadRequestException(String message, String detailedMessage) {
            super(message);
            this.detailedMessage = detailedMessage;
        }

    }
