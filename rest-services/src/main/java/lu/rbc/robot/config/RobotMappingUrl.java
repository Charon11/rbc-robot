package lu.rbc.robot.config;

/**
 * Created by renaudchardin on 31/07/2017.
 */
public class RobotMappingUrl {
    public static final String ADD_ROBOT = "/robot";
    public static final String FIND_ROBOT = "/robot/{robotId}";
    public static final String DELETE_ROBOT = "/robot/{robotId}";
    public static final String DELETE_ALL_ROBOT_BY_STATUS = "/robots/{status}";
    public static final String FIND_BY_STATUS = "/robot/findByStatus";
    public static final String FIND_BY_CATEGORY = "/robot/findByCategory";
    public static final String FIND_BY_NAME = "/robot/findByName";
    public static final String ADD_CATEGORY = "/category";
    public static final String DELETE_CATEGORY = "/category/{categoryId}";
    public static final String GET_CATEGORIES = "/categories";
    public static final String GET_ALL_STATUS = "/status";
    public static final String PLACE_ORDER = "/robot/order/place";
    public static final String CONFIRM_ORDER = "/robot/order/confirm";
    public static final String CANCEL_ORDER = "/robot/order/cancel";

}
