package com.olivia.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {
    /*
     * ConditionContext判断条件 能使用的上下文（环境
     * AnnotatedTypeMetadata 当前标注了condition注解的注释信息
     * */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // whether linux
        //1. 获取当前ioc的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //2. 获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //3. 获取当前环境信息
        Environment environment = context.getEnvironment();
        //4. 注册 查看 删除 bean的定义
        BeanDefinitionRegistry registry = context.getRegistry();

        /*
        * 可以判断ioc中是否有bean
        * 也可以注册
        * */
        boolean person = registry.containsBeanDefinition("person");
        if (person) {

        }
        String property = environment.getProperty("os.name");
        if (property.contains("Linux")) {
            return true;
        }
        return false;
    }
}
