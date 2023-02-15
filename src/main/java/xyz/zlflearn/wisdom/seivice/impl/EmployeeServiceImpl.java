package xyz.zlflearn.wisdom.seivice.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.zlflearn.wisdom.entity.Employee;
import xyz.zlflearn.wisdom.mapper.EmployeeMapper;
import xyz.zlflearn.wisdom.seivice.EmployeeService;

/**
 * @author zhengLongfei
 * @date 2023-02-12-17:01
 */@Service
public class EmployeeServiceImpl  extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{
}
