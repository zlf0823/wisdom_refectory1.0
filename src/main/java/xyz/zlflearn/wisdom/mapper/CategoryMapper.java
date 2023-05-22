package xyz.zlflearn.wisdom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.zlflearn.wisdom.entity.Category;

/**
 * @author zhengLongfei
 * @date 2023-02-16-16:50
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
