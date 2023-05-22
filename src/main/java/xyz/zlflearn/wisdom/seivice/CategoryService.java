package xyz.zlflearn.wisdom.seivice;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import xyz.zlflearn.wisdom.entity.Category;

/**
 * @author zhengLongfei
 * @date 2023-02-16-16:47
 */

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
