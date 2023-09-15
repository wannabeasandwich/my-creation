package cn.tedu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解,一个特殊的类,所有注解都默认继承Annotation接口
 */
@Retention(RetentionPolicy.RUNTIME) //运行时有效
@Target(ElementType.METHOD) //修饰方法
public @interface RequiredLog {
    String operation();
}
