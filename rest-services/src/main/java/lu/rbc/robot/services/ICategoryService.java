package lu.rbc.robot.services;

import lu.rbc.robot.domain.RobotCategory;

import java.util.List;

/**
 * Created by renaudchardin on 01/08/2017.
 */
public interface ICategoryService {
    RobotCategory addCategory(RobotCategory category);
    void deleteCategory(Integer categoryId);
    List<RobotCategory> getAllCategory();
}
