package lu.rbc.robot.services.implement;

import com.google.common.collect.Sets;
import lu.rbc.robot.domain.Robot;
import lu.rbc.robot.domain.RobotCategory;
import lu.rbc.robot.domain.StatusEnum;
import lu.rbc.robot.exception.NotSupportedStatusException;
import lu.rbc.robot.exception.NotSupportedCategoryException;
import lu.rbc.robot.repository.CategoryCrudRepository;
import lu.rbc.robot.repository.RobotCrudRepository;
import lu.rbc.robot.services.IRobotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by renaudchardin on 31/07/2017.
 */
@Service
public class RobotServices implements IRobotServices {

    @Autowired
    private RobotCrudRepository robotCrudRepository;

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    @Override
    public List<Robot> findRobotByStatus(String status) throws NotSupportedStatusException {
        if (this.statusIsValid(status))
            return this.robotCrudRepository.findByStatus(status);
        else
            throw new NotSupportedStatusException(status);
    }

    @Override
    public List<Robot> findRobotByCategory(Integer categoryId) throws NotSupportedCategoryException {
        if (this.categoryCrudRepository.exists(categoryId)) {
            RobotCategory category = this.categoryCrudRepository.findOne(categoryId);
            return this.robotCrudRepository.findByCategory(category);
        } else
            throw new NotSupportedCategoryException(categoryId.toString());
    }

    @Override
    public Robot findRobotById(Integer id) {
        return this.robotCrudRepository.findOne(id);
    }

    @Override
    public List<Robot> findRobotByName(String name) {
        return this.robotCrudRepository.findByNameContaining(name);
    }

    @Override
    public Robot addRobot(Robot robot) throws NotSupportedStatusException, NotSupportedCategoryException {
        if (!this.statusIsValid(robot.getStatus()))
            throw new NotSupportedStatusException(robot.getStatus());
        else if (!this.categoryCrudRepository.exists(robot.getCategory().getId()))
            throw new NotSupportedCategoryException(robot.getCategory().getId().toString());
        else
            return this.robotCrudRepository.save(robot);
    }

    @Override
    public void deleteRobot(Integer id) {
        this.robotCrudRepository.delete(id);
    }

    @Override
    public List<String> getAllStatus() {
        return Arrays.asList(StatusEnum.values()).stream().map(statusEnum -> statusEnum.getStatus()).collect(Collectors.toList());
    }

    private Boolean statusIsValid(String status) {
        return Sets.newHashSet(StatusEnum.values()).stream()
                .anyMatch(e-> e.getStatus().equals(status.toLowerCase()));
    }
}
