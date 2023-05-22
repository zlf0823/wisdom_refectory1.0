package xyz.zlflearn.wisdom.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.zlflearn.wisdom.common.R;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author zhengLongfei
 * @date 2023-02-22-10:38
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    @PostMapping("/upload")
    public R<String> upload(MultipartFile file){
        log.info(file.toString());
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用uuid随机生成文件名
        String fileName = UUID.randomUUID().toString();
        //判断指定文件夹是否存在
        File fileM = new File(basePath);
        if(!fileM.exists()){
            fileM.mkdirs();
        }

        try {
            file.transferTo(new File(basePath + fileName + suffix));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(fileName);
    }
}
