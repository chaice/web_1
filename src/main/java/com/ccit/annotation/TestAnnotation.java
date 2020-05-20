package com.ccit.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TestAnnotation {

    /**
     * @Target 指定注解运用的地方
     * ElementType.TYPE 可以给一个类型进行注解,比如类,接口,枚举
     * ElementType.FIELD 可以给一个属性进行注解
     * ElementType.METHOD 可以给一个方法进行注解
     * ElementType.PARAMETER 可以给一个包进行注解
     * ElementType.CONSTRUCTOR 可以给一个构造方法进行注解
     * ElementType.LOCAL_VARIABLE 可以给一个局部变量进行注解
     * ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
     * ElementType.PACKAGE 可以给一个包进行注解
     * ElementType.TYPE_PARAMETER 可以给一个类型参数进行注解
     * ElementType.TYPE_USE 可以给一个类型进行注解
     *
     * @Documented 能够将注解中的元素包含到Javadoc中
     *
     * @Retention 应用到一个注解上,说明了这个注解的存货时间
     * RetentionPolicy.SOURCE 注解只在源码阶段保留,在编译器进行编译时它将被丢弃忽视
     * RetentionPolicy.CLASS 注解只被保留到编译进行的时候,它并不会被加载到JVM中
     * RetentionPolicy.RUNTIME 注解可以被保留到程序运行的时候,他会被加载到JVM中,所以在程序运行时可以获取到
     *
     * @Inherited 继承,一个父类被@Inherited注解过的注解进行注解,子类会自动继承父类的注解
     *
     * @Repeatable 后面括号中的类是用来存放其他注解
     *
     */
}
