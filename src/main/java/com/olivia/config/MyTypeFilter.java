package com.olivia.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

// 自定义过滤规则
public class MyTypeFilter implements TypeFilter {

    /*
     * metadataReader 读取到当前正在扫描的类的信息
     * metadataReaderFactory 可以获取其他任何类的信息
     *
     * */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
//        获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
//        获取当前正在扫描的类的信息 类型 实现接口
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
//        获取当前类的资源信息（类的路径etc
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("--->" + className);

        if (className.contains("er")) {
            return true;
        }
        return false;
    }
}
