package lu.rbc.robot.repository;

import lu.rbc.robot.domain.RobotCategory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by renaudchardin on 31/07/2017.
 */
public interface CategoryCrudRepository extends CrudRepository<RobotCategory, Integer> {
}
