package cn.tedu.controller;

import cn.tedu.annotation.ClearCache;
import cn.tedu.annotation.RequiredCache;
import cn.tedu.annotation.RequiredLog;
import cn.tedu.entity.Product;
import cn.tedu.mapper.ProductMapper;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Date;
import java.util.List;
@Api(tags = "3.商品处理类")
@ApiSupport(author = "田浩")
@RestController
public class ProductController {
    @Autowired
    private ProductMapper mapper;

    //发布新商品
    @ClearCache
    @ApiOperation("发布商品")
    @ApiOperationSupport(order = 7)
    @PostMapping("product/insert")
    public void insert(@RequestBody @ApiParam("商品") Product product) {
        product.setCreated(new Date());
        mapper.insert(product);
    }

    /**查询前端系统首页商品列表信息*/
    @Transactional(readOnly = true)
    @RequiredLog(operation = "查询所有商品")
    @RequiredCache
    @ApiOperation("查询所有商品")
    @ApiOperationSupport(order = 1)
    @GetMapping("product/list/index")
    public List<Product> doSelectIndex() {
        System.out.println(Thread.currentThread().getName()+"-->ProductController.doSelectIndex()");
        return mapper.selectIndex();
    }

    /**查询前端系统首页商品列表信息*/
    @ApiOperation("查询后台商品")
    @ApiOperationSupport(order = 6)
    @GetMapping("product/list/admin")
    public List<Product> doSelectAdmin() {
        return mapper.selectAdmin();
    }

    /**查询商品销量并在前端系统中显示*/
    @ApiOperation("查询排行榜商品")
    @ApiOperationSupport(order = 2)
    @GetMapping("product/list/top")
    public List<Product> doSelectTop() {
        List<Product> list = mapper.selectTop();
        for (Product p : list) {
            if (p.getTitle().length() > 3) {
                String title = p.getTitle().substring(0,3)+"...";
                p.setTitle(title);
            }
        }
        return list;
    }

    /**基于关键字查询某个商品*/
    @ApiOperation("基于关键字查询商品")
    @ApiOperationSupport(order = 4)
    @GetMapping("product/selectByWd/{keyWord}")
    public List<Product> doSelectByWd(@PathVariable String keyWord) {
        return mapper.selectByWd(keyWord);
    }

    /**基于id查询某个商品*/
    @GetMapping("product/select/{id}")
    @ApiOperation("基于id查询商品")
    @ApiOperationSupport(order = 3)
    public Product doSelectById(@PathVariable Integer id) {
        //让浏览量+1
        mapper.updateViewCount(id);
        return mapper.selectById(id);
    }

    /**基于商品分类id查询商品信息*/
    @ApiOperation("基于分类查询商品")
    @ApiOperationSupport(order = 5)
    @GetMapping("product/selectByCid/{cid}")
    public List<Product> doSelectByCid(@PathVariable Integer cid) {
        return mapper.selectByCid(cid);
    }

    @RequiredLog(operation = "根据id删除商品")
    @Transactional(
            timeout = 30,
            readOnly = false,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = Throwable.class,
            propagation = Propagation.REQUIRED)
    @ApiOperation("删除商品")
    @ApiOperationSupport(order = 8)
    @ApiImplicitParam(name = "id",value = "商品id",example = "1",required = true,dataType = "int")
    @DeleteMapping("product/delete/{id}")
    public void doDeleteById(@PathVariable Integer id) {
        String url = mapper.selectUrlById(id);
        //完整路径
        String filePath = "d:/file/"+url;
        new File(filePath).delete();
        //删除数据库中的数据
        mapper.deleteById(id);
    }
}
