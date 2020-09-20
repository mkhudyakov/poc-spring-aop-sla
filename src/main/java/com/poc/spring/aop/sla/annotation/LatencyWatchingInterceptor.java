package com.poc.spring.aop.sla.annotation;

import com.poc.spring.aop.sla.service.LogService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LatencyWatchingInterceptor implements MethodInterceptor {

    private final LogService logService;

    LatencyWatchingInterceptor(LogService logService) {
        this.logService = logService;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation)
            throws Throwable {

        long start = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        logService.log(methodInvocation.getMethod().getName(), System.currentTimeMillis() - start);

        return result;
    }
}
