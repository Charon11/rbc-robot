package lu.rbc.robot.exception;

/**
 * Created by renaudchardin on 31/07/2017.
 */
public class NotSupportedStatusException extends Exception {
    public NotSupportedStatusException(String status) {
        super(String.format("Status %s not supported", status));
    }
}
