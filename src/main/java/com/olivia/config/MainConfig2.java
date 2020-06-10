package com.olivia.config;

import com.olivia.bean.Person;
import com.olivia.condition.LinuxCondition;
import com.olivia.condition.MacOSCondition;
import com.olivia.condition.WindowsCondition;
import org.springframework.context.annotation.*;
/*
* @Condition 放在类上
* 满足当前条件 这个类中配置的所有bean注册才能生效
* 类中组件同意设置
* */
@Conditional({MacOSCondition.class})
@Configuration // 告诉Spring这是一个配置类
public class MainConfig2 {
    /* @Scope 调整作用域
     * prototype 多实例 IOC容器启动时候并不会调用方法创建对象，而是我们每次获取的时候才会去创建方法，并且每次获取的时候都会创建对象
     * singleton 但实例（默认值）IOC期中会调用方法创建对象直接放在IOC容器中，以后每次获取就直接从容器（map）中拿
     * request 同一次请求创建一个实例
     * session 同一个session创建一个
     *
     * */

    /*懒加载(延迟加载)：-- 针对单实例
     * 单实例bean 默认在容器启动的时候创建对象
     * 懒加载：容器启动的时候不创建，在第一次获取Bean的时候创建对象，并初始化*/
//    @Scope("prototype")
    //默认单实例
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("add person to continer");
        return new Person("olivia", 25);

    }

    /*@Conditional 按照一定条件进行判断，满足条件给容器中注册bean
    传入condition数组
    * if system == windows --> bean = bill
    * if system == linux --> bean = linus
    * */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02() {
        return new Person("Linus", 48);
    }

    @Bean("steven")
    public Person person03() {
        return new Person("Steven Jobs", 45);
    }
}
