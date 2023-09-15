package cn.tedu.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Aspect 注解描述的类型为一个切面类型,这样的切面类型通常会定义两部分内容:
 * 1>切入点:切入拓展功能的点(例如业务对象中的一个或者多个方法)
 * 2>通知:在切点对应的方法执行时,要织入的拓展功能
 */
@Aspect
@Slf4j
@Component
public class SysLogAspect {
    /**
     * @Pointcut 注解一般用于描述方法,在方法上定义切入点
     * bean(productController) 为一个切入点表达式
     */
    @Pointcut("bean(productController)")
    public void logPointCut(){} //方法内部不需要写任何内容

    /**
     * 通知,在通知中写额外增强功能的代码
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        //记录方法执行开始时间
        long t1 = System.currentTimeMillis();
        try {
            //调用目标方法
            Object result = jp.proceed(); //调用本切面中其他通知或下一个切面中通知或目标方法
            //记录方法执行的结束时间以及总时长
            long t2 = System.currentTimeMillis();
            log.info("method execute time {}",(t2-t1));
            return result;
        } catch (Throwable e) {
            //出现异常时还要输出错误日志
            log.error("error is {}",e.getMessage());
            throw e;
        }
    }
}
