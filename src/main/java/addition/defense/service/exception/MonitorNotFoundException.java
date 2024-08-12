package addition.defense.service.exception;

public class MonitorNotFoundException extends RuntimeException {

    public MonitorNotFoundException(String message) {
        super(message);
    }

    public MonitorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
