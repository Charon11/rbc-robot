package lu.rbc.robot.controller;

import lu.rbc.robot.config.RobotMappingUrl;
import lu.rbc.robot.domain.RobotCategory;
import lu.rbc.robot.exception.NotSupportedStatusException;
import lu.rbc.robot.exception.NotSupportedCategoryException;
import lu.rbc.robot.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by renaudchardin on 01/08/2017.
 */
@RestController
@RequestMapping("/api")
public class CategoryRestController {

    @Autowired
    private ICategoryService categoryService;


    @RequestMapping(value = RobotMappingUrl.ADD_CATEGORY, method = RequestMethod.POST)
    public ResponseEntity addCategory(@RequestBody RobotCategory category) throws NotSupportedStatusException, NotSupportedCategoryException {
        return new ResponseEntity(this.categoryService.addCategory(category), HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.DELETE_CATEGORY, method = RequestMethod.DELETE)
    public ResponseEntity deleteCategory(@PathVariable(value = "categoryId") Integer id) {
        this.categoryService.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = RobotMappingUrl.GET_CATEGORIES, method = RequestMethod.GET)
    public ResponseEntity getAllCategories() {
        return new ResponseEntity(this.categoryService.getAllCategory(), HttpStatus.OK);
    }

}
