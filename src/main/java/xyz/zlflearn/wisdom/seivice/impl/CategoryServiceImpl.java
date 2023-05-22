package xyz.zlflearn.wisdom.seivice.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.zlflearn.wisdom.common.CustomException;
import xyz.zlflearn.wisdom.entity.Category;
import xyz.zlflearn.wisdom.entity.Dish;
import xyz.zlflearn.wisdom.entity.Setmeal;
import xyz.zlflearn.wisdom.mapper.CategoryMapper;
import xyz.zlflearn.wisdom.seivice.CategoryService;
import xyz.zlflearn.wisdom.seivice.DishService;
import xyz.zlflearn.wisdom.seivice.SetmealService;

import javax.annotation.Resource;

/**
 * @author zhengLongfei
 * @date 2023-02-16-16:49
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{
    @Autowired
    private SetmealService setmealService;
    @Autowired
    private DishService dishService;
    @Override
    public void remove(Long id) {
        //查询该分类下是否有菜品，如果有，抛出异常。
        LambdaQueryWrapper<Dish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count = dishService.count(lambdaQueryWrapper);
        if(count > 0){
            //抛出异常。
            throw new CustomException("删除失败，有关联的菜品！");
        }
        //查询是否有关联的套餐
        LambdaQueryWrapper<Setmeal> lambdaQueryWrapper2 = new LambdaQueryWrapper<>();
        lambdaQueryWrapper2.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(lambdaQueryWrapper2);
        if(count2 > 0){
            //有关联的套餐，抛出异常。
            throw new CustomException("删除失败，有关联的套餐！");

        }
        super.removeById(id);
    }
}
