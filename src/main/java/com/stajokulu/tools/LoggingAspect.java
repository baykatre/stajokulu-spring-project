package com.stajokulu.tools;

import com.stajokulu.history.History;
import com.stajokulu.history.HistoryService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
@RequiredArgsConstructor
public class LoggingAspect {

    private final HistoryService historyService;

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    private void selectControllerMethods() {}

    @Around("selectControllerMethods()")
    public Object logProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object object = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;

        final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        final String operationType = signature.getMethod().getName();

        final History history =
                History.builder()
                        .operationType(operationType)
                        .executionTime(executionTime)
                        .build();
        historyService.save(history);

        return object;
    }
}
