package xyz.zlflearn.wisdom.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.zlflearn.wisdom.common.R;
import xyz.zlflearn.wisdom.entity.Category;
import xyz.zlflearn.wisdom.seivice.CategoryService;

/**
 * @author zhengLongfei
 * @date 2023-02-15-17:51
 */
@RequestMapping("/category")
@RestController
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /*
     * 新增
     * @description: 
     * @param category
     * @return: xyz.zlflearn.wisdom.common.R<java.lang.String>
     * @author: Administrator
     * @time: 2023/2/16 0016 17:23
     */
    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info(category.toString());
        categoryService.save(category);
        return R.success("保存成功！");
    }
    /*分页查询
     * @description:
     * @param page
     * @param pageSize
     * @return: xyz.zlflearn.wisdom.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page>
     * @author: Administrator
     * @time: 2023/2/16 0016 17:31
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize){
        Page<Category> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Category> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByAsc(Category::getSort);
        categoryService.page(pageInfo,lambdaQueryWrapper);
        return R.success(pageInfo);
    }

    @DeleteMapping
    public R<String> delete(Long ids){
        log.info("删除分类,id为：{}",ids);
        boolean b = categoryService.removeById(ids);
        categoryService.remove(ids);
        if(b){
            return R.success("删除成功！");
        }
        return R.error("删除失败！");

    }

    @PutMapping
    public R<String> update(@RequestBody Category category){
        log.info(category.toString());

        categoryService.updateById(category);

        return R.success("修改成功！");
    }
}
