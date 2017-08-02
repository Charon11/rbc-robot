package lu.rbc.robot.repository;

import lu.rbc.robot.domain.Robot;
import lu.rbc.robot.domain.RobotCategory;
import lu.rbc.robot.domain.StatusEnum;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by renaudchardin on 31/07/2017.
 */
public interface RobotCrudRepository extends CrudRepository<Robot, Integer>, JpaSpecificationExecutor<Robot> {

    List<Robot> findByStatus(String status);

    List<Robot> findByCategory(RobotCategory category);

    void deleteAllByStatus(String status);

    List<Robot> findByNameContainingIgnoreCase(String name);
}
