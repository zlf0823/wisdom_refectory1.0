package xyz.zlflearn.wisdom.seivice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.zlflearn.wisdom.entity.Dish;
import xyz.zlflearn.wisdom.mapper.DishMapper;
import xyz.zlflearn.wisdom.seivice.DishService;

/**
 * @author zhengLongfei
 * @date 2023-02-21-18:25
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
