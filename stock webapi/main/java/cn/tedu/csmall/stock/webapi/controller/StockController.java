package cn.tedu.csmall.stock.webapi.controller;

import cn.tedu.csmall.commons.exception.CoolSharkServiceException;
import cn.tedu.csmall.commons.pojo.stock.dto.StockReduceCountDTO;
import cn.tedu.csmall.commons.restful.JsonResult;
import cn.tedu.csmall.commons.restful.ResponseCode;
import cn.tedu.csmall.stock.service.IStockService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base/stock")
@Api(tags = "库存管理")
@RefreshScope
public class StockController {

    // @Value用于将值注入到应用程序中的各组件中，允许将配置文件中的值注入到SpringBean中
    @Value("${admin.name}")
    private String adminName;

    @Autowired
    private IStockService stockService;

    @PostMapping("/reduce/count")
    @ApiOperation("减少商品库存数")
    // @SentinelResource注解标记的控制的方法，会被Sentinel管理
    // 在这个方法第一次运行后，才可以在Sentinel仪表台界面中看到，并设置限流规则
    // "减少库存的方法"设置当前方法在仪表台的显示名称
    // blockHandler 指定请求限流时运行的方法
    // fallback 控制器方法发生异常时，要执行的降级方法名称
    @SentinelResource(value = "减少库存的方法",blockHandler = "blockError",fallback = "fallbackError")
    public JsonResult reduceCommodityCount(StockReduceCountDTO stockReduceCountDTO) throws InterruptedException {

        System.out.println("adminName:"+adminName);

        // 调用业务逻辑层
        stockService.reduceCommodityCount(stockReduceCountDTO);

        // Thread.sleep(5000); // 测试线程并发数

        // if (Math.random()<0.5){
        //     throw new CoolSharkServiceException(ResponseCode.INTERNAL_SERVER_ERROR,"抛出随机异常");
        // }

        return JsonResult.ok("商品库存减少完成!");
    }

    /**
     * Sentinel 自定义限流方法的定义
     * 访问修饰词 public
     * 返回值 与 限流的控制器方法 一致
     * 方法名 与 @SentinelResource(blockHandler = "blockError") 指定的方法名一致
     * 参数列表 与 限流的控制器方法 一致，同时额外添加 BlockException类型的参数(用于处理限流时产生的异常信息)
     */
    public JsonResult blockError(StockReduceCountDTO stockReduceCountDTO, BlockException e){
        // 触发限流，返回限流信息
        return JsonResult.failed(ResponseCode.BAD_REQUEST,"服务器忙，请稍后再试");
    }

    /**
     * Sentinel 注解中fallback指定的降级方法
     * 当原定运行的控制器方法发生异常时，Sentinel会运行下面的方法（可以编写正常逻辑做补救措施）
     */
    public JsonResult fallbackError(StockReduceCountDTO stockReduceCountDTO){
        return JsonResult.failed(ResponseCode.BAD_REQUEST,"因为运行时发生异常，服务降级");
    }



}














