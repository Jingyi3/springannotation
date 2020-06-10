package com.olivia.test;

import com.olivia.bean.Person;
import com.olivia.config.MainConfig;
import com.olivia.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @SuppressWarnings("resource")
    @Test
    public void test01() {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        Person bean = (Person) applicationContext.getBean("person");
        Person bean2 = (Person) applicationContext.getBean("person");
        System.out.println(bean == bean2);
    }

    @SuppressWarnings("resource")
    @Test
    public void test02() {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String name : beanDefinitionNames) {
//            System.out.println(name);
//        }
        System.out.println("IOC continer created");
        Person bean = (Person) applicationContext.getBean("person");
        Person bean2 = (Person) applicationContext.getBean("person");
//        System.out.println(bean == bean2);
    }

    @Test
    public void test03() {
        // 获取环境变量 -- os

        /*
        * 可以更改configuration 里面的vm option -Dos.name=Linux 就变成linux系统了
        * */
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }
}
