package lu.rbc.robot.controller;

import lu.rbc.robot.config.RobotMappingUrl;
import lu.rbc.robot.domain.Robot;
import lu.rbc.robot.exception.NotSupportedStatusException;
import lu.rbc.robot.exception.NotSupportedCategoryException;
import lu.rbc.robot.services.IRobotServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by renaudchardin on 31/07/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class RobotRestController {

    @Autowired
    private IRobotServices robotServices;

    @RequestMapping(value = RobotMappingUrl.FIND_BY_STATUS, method = RequestMethod.GET)
    public ResponseEntity findRobotByStatus(@RequestParam String status) throws NotSupportedStatusException {
        return new ResponseEntity(this.robotServices.findRobotByStatus(status), HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.FIND_BY_CATEGORY, method = RequestMethod.GET)
    public ResponseEntity findRobotByCategory(@RequestParam Integer categoryId) throws NotSupportedCategoryException {
        return new ResponseEntity(this.robotServices.findRobotByCategory(categoryId), HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.FIND_BY_NAME, method = RequestMethod.GET)
    public ResponseEntity findRobotByName(@RequestParam String name) {
        return new ResponseEntity(this.robotServices.findRobotByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.FIND_ROBOT, method = RequestMethod.GET)
    public ResponseEntity findRobotById(@PathVariable(value = "robotId") Integer id) {
        return new ResponseEntity(this.robotServices.findRobotById(id), HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.ADD_ROBOT, method = RequestMethod.POST)
    public ResponseEntity addRobot(@RequestBody Robot robot) throws NotSupportedStatusException, NotSupportedCategoryException {
        return new ResponseEntity(this.robotServices.addRobot(robot), HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.CONFIRM_ORDER, method = RequestMethod.POST)
    public ResponseEntity confirmOrder(@RequestParam Integer robotId) throws NotSupportedStatusException, NotSupportedCategoryException {
        return new ResponseEntity(this.robotServices.confirmOrder(robotId), HttpStatus.OK);
    }


    @RequestMapping(value = RobotMappingUrl.CANCEL_ORDER, method = RequestMethod.POST)
    public ResponseEntity cancelOrder(@RequestParam Integer robotId) throws NotSupportedStatusException, NotSupportedCategoryException {
        return new ResponseEntity(this.robotServices.cancelOrder(robotId), HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.PLACE_ORDER, method = RequestMethod.POST)
    public ResponseEntity placeOrder(@RequestParam Integer robotId) throws NotSupportedStatusException, NotSupportedCategoryException {
        return new ResponseEntity(this.robotServices.placeOrder(robotId), HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.DELETE_ROBOT, method = RequestMethod.DELETE)
    public ResponseEntity deleteRobot(@PathVariable(value = "robotId") Integer id) {
        this.robotServices.deleteRobot(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.DELETE_ALL_ROBOT_BY_STATUS, method = RequestMethod.DELETE)
    public ResponseEntity deleteAllRobotByStatus(@PathVariable(value = "status") String status) throws NotSupportedStatusException {
        this.robotServices.deleteAllByStatus(status);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.GET_ALL_STATUS, method = RequestMethod.GET)
    public ResponseEntity getAllStatus() {
        return new ResponseEntity(this.robotServices.getAllStatus(), HttpStatus.OK);
    }
}
