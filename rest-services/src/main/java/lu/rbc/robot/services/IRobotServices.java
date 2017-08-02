package lu.rbc.robot.services;

import lu.rbc.robot.domain.Robot;
import lu.rbc.robot.exception.NotSupportedStatusException;
import lu.rbc.robot.exception.NotSupportedCategoryException;

import java.util.List;

/**
 * Created by renaudchardin on 31/07/2017.
 */
public interface IRobotServices {

    List<Robot> findRobotByStatus(String status) throws NotSupportedStatusException;

    List<Robot> findRobotByCategory(Integer categoryId) throws NotSupportedCategoryException;

    Robot findRobotById(Integer id);

    List<Robot> findRobotByName(String name);

    Robot addRobot(Robot robot) throws NotSupportedStatusException, NotSupportedCategoryException;

    void deleteRobot(Integer id);

    List<String> getAllStatus();

    void deleteAllByStatus(String status) throws NotSupportedStatusException;

}
