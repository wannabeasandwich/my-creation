package cn.tedu.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Api(tags = "5.上传处理类")
@RestController
public class UploadController<pubilc> {
    private String dirPath = "D:/file";

    @PostMapping("upload")
    public String upload(MultipartFile picFile) throws IOException {
        //得到原始文件名
        String fileName = picFile.getOriginalFilename();
        System.out.println("原名:"+fileName);
        //得到后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //修改文件名
        fileName = UUID.randomUUID()+suffix;
        System.out.println("新名:"+fileName);
        //得到文件完整路径
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        String filrPath = dirPath+"/"+fileName;
        //保存文件到此路径中
        picFile.transferTo(new File(filrPath));
        //返回文件名,删除时使用此文件名
        return fileName;
    }

    @DeleteMapping("remove")
    public void remove(String name) {
        String filePath = dirPath+"/"+name;
        File file = new File(filePath);
        if (file.exists()) {
            file.delete(); //删除文件
        }
    }
}
