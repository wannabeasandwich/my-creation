package cn.tedu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class TimeInterceptor implements HandlerInterceptor {
    /*
     * preHandle在控制层目标方法执行之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandler()");
        //获取Java中的日历对象
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY,21);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        long start = c.getTimeInMillis();
        c.set(Calendar.HOUR_OF_DAY,23);
        long end = c.getTimeInMillis();
        long cTime = System.currentTimeMillis();
        if (cTime < start || cTime > end) throw new RuntimeException("不在访问时间内!");
        return true; //表示放行,允许访问资源
    }
}
