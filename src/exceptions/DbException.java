package exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DbException extends RuntimeException{
    private final String message;
    @Override
    public String getMessage() {
        return message;
    }
}
