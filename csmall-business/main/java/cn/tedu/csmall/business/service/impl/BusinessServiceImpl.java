package cn.tedu.csmall.business.service.impl;

import cn.tedu.csmall.business.service.IBusinessService;
import cn.tedu.csmall.commons.exception.CoolSharkServiceException;
import cn.tedu.csmall.commons.pojo.order.dto.OrderAddDTO;
import cn.tedu.csmall.commons.restful.ResponseCode;
import cn.tedu.csmall.order.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessServiceImpl implements IBusinessService {

    @DubboReference
    private IOrderService dubboOrderService;

    // 全局事务注解(所有远程调用对数据库的操作，要么全部成功，要么全部失败)
    @GlobalTransactional
    @Override
    public void buy() {
        // 模拟购买业务
        // 创建一个OrderAddDTO类,并为它赋值
        OrderAddDTO orderAddDTO=new OrderAddDTO();
        orderAddDTO.setUserId("UU100");
        orderAddDTO.setCommodityCode("PC100");
        orderAddDTO.setCount(5);
        orderAddDTO.setMoney(500);
        // 模拟购买只是输出到控制台即可
        log.info("新增订单的信息为:{}",orderAddDTO);

        // 调用order业务
        dubboOrderService.orderAdd(orderAddDTO);

        // 为了验证seata实现的分布式事务效果(观察事务回滚)
        if(Math.random()<0.5){
            throw new CoolSharkServiceException(ResponseCode.INTERNAL_SERVER_ERROR,"发生随机异常，本次操作回滚！");
        }

    }
}