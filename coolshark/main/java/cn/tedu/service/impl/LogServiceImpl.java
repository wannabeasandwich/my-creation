package cn.tedu.service.impl;

import cn.tedu.entity.Log;
import cn.tedu.mapper.LogMapper;
import cn.tedu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    /*
     * @Async 描述的方法为一个异步切入点方法,
     * 此方法会在spring提供的线程池中的线程上运行
     */
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    @Transactional(propagation = Propagation.REQUIRED)
    @Async
    @Override
    public void insert(Log log) {
        System.out.println(Thread.currentThread().getName()+"-->LogServiceImpl.insert()");
        System.out.println(log);
        //模拟写的耗时操作
        try {Thread.sleep(5000);}catch (Exception e){}
        logMapper.insert(log);
    }
}
