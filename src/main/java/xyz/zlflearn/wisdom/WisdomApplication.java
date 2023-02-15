package xyz.zlflearn.wisdom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author zhengLongfei
 * @date 2023-02-12-16:18
 */
@SpringBootApplication
@Slf4j
@ServletComponentScan
public class WisdomApplication {
    public static void main(String[] args) {
        SpringApplication.run(WisdomApplication.class,args);
        log.info("项目启动成功...");
    }
}
