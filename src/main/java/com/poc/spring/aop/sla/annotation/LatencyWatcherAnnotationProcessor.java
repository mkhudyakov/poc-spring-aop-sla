package com.poc.spring.aop.sla.annotation;

import com.poc.spring.aop.sla.service.LogService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LatencyWatcherAnnotationProcessor implements BeanPostProcessor {

    @Autowired
    private LogService logService;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(final Object bean, String beanName)
            throws BeansException {

        Class<?> managedBeanClass = bean.getClass();
        if (managedBeanClass.isAnnotationPresent(LatencyWatcher.class)) {
            return proxyBean(bean);
        } else {
            return bean;
        }
    }

    private Object proxyBean(Object bean) {
        ProxyFactory proxyFactory = new ProxyFactory(bean);
        proxyFactory.addAdvice(new LatencyWatchingInterceptor(logService));
        return proxyFactory.getProxy();
    }
}
