package com.ccit.annotation;

import java.lang.annotation.*;

//该注解是否包含在javaDoc中
@Documented
//注解用于什么地方,不明确指出,该注解可放在任何地方
@Target(ElementType.TYPE)
//什么时候使用该注解
/**
 * RetentionPolicy.SOURCE 在编译阶段丢弃,编译结束后没有任何意义,所以不会写入字节码
 * RetentionPolicy.CLASS 在类加载的时候丢弃.在字节码文件的处理中有用.注解默认使用这种方式
 * RetentionPolicy.RUNTIME 始终不会丢弃,运行期也保留该注解,因此可以使用反射读取该注解的信息
 */
@Retention(RetentionPolicy.RUNTIME)
//是否允许子类继承该注解
@Inherited
public @interface Person {

    String role() default "";

}
