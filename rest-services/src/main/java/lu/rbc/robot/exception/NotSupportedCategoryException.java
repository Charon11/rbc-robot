package lu.rbc.robot.exception;

/**
 * Created by renaudchardin on 31/07/2017.
 */
public class NotSupportedCategoryException extends Exception {
    public NotSupportedCategoryException(String category) {
        super(String.format("Category %s not supported", category));
    }
}
