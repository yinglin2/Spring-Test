package com.spring.resourceloaderaware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * ResourceLoaderAware: 该接口实现类的实例将获得一个ResourceLoader的引用
 *
 *
 *
 如果把实现ResourceLoaderAware接口的Bean类部署在Spring容器中，Spring容器会将自身当成
 ResourceLoader作为setResourceLoader()方法的参数传入。
 由于ApplicationContext的实现类都实现了 ResourceLoader接口，Spring容器自身完全可作为ResorceLoader使用。

 */
public class TestBean implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
