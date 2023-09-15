package cn.tedu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//@Order(2)
@Aspect
@Component
public class CacheAspect {
    private Map<Object,Object> cache = new ConcurrentHashMap<>();

    @Pointcut("@annotation(cn.tedu.annotation.RequiredCache)")
    public void doCache(){}

    @Pointcut("@annotation(cn.tedu.annotation.ClearCache)")
    public void doClear(){}

    //注意,这里选用返回通知,因为只有业务代码执行成功才能执行此通知
    @AfterReturning("doClear()")
    public void doAfterReturning() {
        cache.clear();
    }

    @Around("doCache()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Cache2");
        System.out.println("Get data from cache");
        Object result = cache.get("dataKey");
        if (result != null) return result;
        result = jp.proceed(); //执行目标方法
        System.out.println("Put data to cache");
        cache.put("dataKey",result);
        return result;
    }
}
