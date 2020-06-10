package com.olivia.config;

import com.olivia.bean.Person;
import com.olivia.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

// 配置类==配置文件.xml
@Configuration //告诉spring这是一个配置类

@ComponentScans(value = {
        @ComponentScan(value = "com.olivia", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class})//只要是bookservice的组件都会加在容器中
@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
        }, useDefaultFilters = false)
})

//@ComponentScan value:指定要扫描的包
//指定扫描的时候按照什么规则排除哪些组件
//    ComponentScan.Filter[] excludeFilters() default {};
// 指定扫描的时候按 只需要包含哪些组件 *注意如果要让这个生效 需要 useDefaultFilters = false 让default
//    ComponentScan.Filter[] includeFilters() default {};

//type = FilterType.ANNOTATION 按照注解
//type = FilterType.ASSIGNABLE_TYPE 按照指定的类型


public class MainConfig {

    //给容器中注册一个bean;类型是返回值的类型，id默认是方法名字作为id
    @Bean("person")
    public Person person01() {
        return new Person("lisa", 20);
    }

}
