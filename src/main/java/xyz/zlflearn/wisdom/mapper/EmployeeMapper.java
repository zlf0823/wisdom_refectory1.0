package xyz.zlflearn.wisdom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.zlflearn.wisdom.entity.Employee;

/**
 * @author zhengLongfei
 * @date 2023-02-12-16:58
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
