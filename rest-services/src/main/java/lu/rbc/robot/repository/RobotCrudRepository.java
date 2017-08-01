package lu.rbc.robot.repository;

import lu.rbc.robot.domain.Robot;
import lu.rbc.robot.domain.RobotCategory;
import lu.rbc.robot.domain.StatusEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by renaudchardin on 31/07/2017.
 */
public interface RobotCrudRepository extends CrudRepository<Robot, Integer> {

    List<Robot> findByStatus(String status);

    List<Robot> findByCategory(RobotCategory category);

    void deleteAllByStatus(StatusEnum status);

    List<Robot> findByNameContaining(String name);
}
