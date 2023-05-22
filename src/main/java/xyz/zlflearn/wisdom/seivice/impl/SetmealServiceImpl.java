package xyz.zlflearn.wisdom.seivice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.zlflearn.wisdom.entity.Setmeal;
import xyz.zlflearn.wisdom.mapper.SetmealMapper;
import xyz.zlflearn.wisdom.seivice.SetmealService;

/**
 * @author zhengLongfei
 * @date 2023-02-16-17:36
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
