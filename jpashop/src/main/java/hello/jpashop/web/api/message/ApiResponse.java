package hello.jpashop.web.api.message;

import org.springframework.http.HttpStatus;

public class ApiResponse {

    private HttpStatus httpStatus;
    private String message;

    public ApiResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
