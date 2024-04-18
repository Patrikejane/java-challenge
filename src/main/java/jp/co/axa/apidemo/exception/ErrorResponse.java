package jp.co.axa.apidemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String errorMessage;
    private int statusCode;
    private String timeStamp; // Timestamp when the error occurred
    private String detailedErrorMessage; // Detailed error message
}