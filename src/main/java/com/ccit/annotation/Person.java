package com.ccit.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Persons.class)
public @interface Person {

    String role() default "";

}
