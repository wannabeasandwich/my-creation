package cn.tedu.config;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Setter
@Configuration //此注解描述的类为一个配置类,需要交给Spring管理
//读取Spring配置文件中以spring.async.task为前缀的数据
@ConfigurationProperties("spring.async.task")
public class SpringAsyncConfig implements AsyncConfigurer {
    private int corePoolSize = 5;
    private int maxPoolSize = 100;
    private int keepAliveSeconds = 60;
    private int queueCapacity = 128;
    private String threadNamePrefix = "task===>";

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        //自定义拒绝处理策略
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                log.error("队列已满并且已无线程可用!");
            }
        });
        executor.initialize();
        return executor;
    }

    //当执行有异常时
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                log.error("任务执行出现了 {}",ex.getMessage());
            }
        };
    }
}
