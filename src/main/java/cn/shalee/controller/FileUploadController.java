package cn.shalee.controller;

import cn.shalee.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @version 1.0
 * @Author shalee
 * @Date 2024/6/9 22:11
 * @注释
 */
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {

        String imgUrl = "/Users/leeshal/Desktop/OneWork/src/main/resources/upload/image/";
        String workUrl = "/Users/leeshal/Desktop/OneWork/src/main/resources/upload/work/";

        //把文件存储在本地
        //UUID保证文件名字唯一
        UUID uuid = UUID.randomUUID();
        String originalFilename = file.getOriginalFilename();
        String endIndex = file.getOriginalFilename().substring(originalFilename.lastIndexOf("."));
        String fileName = uuid.toString() + endIndex;

        if (endIndex.contains("png") || endIndex.contains("jpg")) {
            file.transferTo(new File(imgUrl + fileName));
            return Result.success("url访问地址为" + imgUrl + fileName);

        } else {
            file.transferTo(new File(workUrl + fileName));
            return Result.success("url访问地址为" + workUrl + fileName);

        }
    }
}
