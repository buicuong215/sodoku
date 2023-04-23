package exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileException extends RuntimeException{
    private final String message;

    @Override
    public String getMessage() {
        return message;
    }
}
