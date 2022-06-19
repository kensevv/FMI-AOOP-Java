package p11;

import java.io.IOException;

public class CheckedStringTooLongException extends IOException {
    public CheckedStringTooLongException(String messsage) {
        super(messsage);
    }
}
