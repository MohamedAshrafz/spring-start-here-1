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
@Order(2)
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Log Aspect: Invoked");

        // Will return nothing, but you can keep it as nothing is still be a null object
        Object returnedVal = joinPoint.proceed();

        logger.info("Log Aspect: Finished");

        return returnedVal;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
