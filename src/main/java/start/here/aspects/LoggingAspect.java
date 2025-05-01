package start.here.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("aspect log was called");

        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Method " + methodName + " with parameters " + Arrays.toString(args) + " will execute");

        // Will return nothing, but you can keep it as nothing is still be a null object
        Object returnedVal = joinPoint.proceed();

        logger.info("aspect log will be finished now");

        return returnedVal;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
