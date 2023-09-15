package cn.tedu.controller;


import cn.tedu.cache.CacheConstants;
import cn.tedu.entity.Category;
import cn.tedu.mapper.CategoryMapper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(tags = "2.分类处理类")
@RestController
public class CategoryController {

    @Autowired
    private CategoryMapper mapper;

    @PostMapping("category/insert")
    @CacheEvict(value = CacheConstants.CACHE2,allEntries = true)
    public void insert(@RequestBody Category category) {
        mapper.insert(category);
    }

    @GetMapping("category/list")
    @Cacheable(value = CacheConstants.CACHE2,sync = true)
    public List<Category> list() {
        System.out.println("===获取数据===");
        return mapper.list();
    }

    @DeleteMapping("category/delete/{id}")
    @CacheEvict(value = CacheConstants.CACHE2,allEntries = true)
    public void delete(@PathVariable int id) {
        mapper.deleteById(id);
    }
}
