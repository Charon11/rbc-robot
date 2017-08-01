package lu.rbc.robot.services.implement;

import com.google.common.collect.Lists;
import lu.rbc.robot.domain.RobotCategory;
import lu.rbc.robot.repository.CategoryCrudRepository;
import lu.rbc.robot.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renaudchardin on 01/08/2017.
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    @Override
    public RobotCategory addCategory(RobotCategory category) {
        return this.categoryCrudRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        this.categoryCrudRepository.delete(categoryId);
    }

    @Override
    public List<RobotCategory> getAllCategory() {
        return Lists.newArrayList(this.categoryCrudRepository.findAll());
    }
}
