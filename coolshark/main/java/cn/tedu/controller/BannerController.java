package cn.tedu.controller;

import cn.tedu.entity.Banner;
import cn.tedu.mapper.BannerMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
@Api(tags = "1.轮播图处理类")
@RestController
public class BannerController {
    @Autowired
    private BannerMapper mapper;

    @GetMapping("banner/list")
    public List<Banner> list() {
        return mapper.list();
    }

    @PostMapping("banner/insert")
    public void insert(@RequestBody Banner banner) {
        mapper.insert(banner);
    }

    @DeleteMapping("banner/delete/{id}")
    public void delete(@PathVariable int id) {
        //得到删除轮播图的图片名
        String url = mapper.selectUrlById(id);
        //得到文件的完整路径
        String filePath = "D:/file/"+url;
        //删除文件
        new File(filePath).delete();

        mapper.deleteById(id);
    }
}
