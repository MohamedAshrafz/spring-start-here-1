package start.here.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* start.here.services.CommentService.submitComment(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//        logger.info("aspect log was called");

//        logger.info(Arrays.toString(joinPoint.getArgs()));
//        logger.info(joinPoint.getSignature().toString());


        Object [] newArgs = {"hi there i hacked you :'D"};
        // Changing the provided parameter
        Object returnedVal = joinPoint.proceed(newArgs);
        logger.info("The actual returned value by the method is [" + returnedVal.toString() + "]");

//        logger.info("aspect log was concluded");

        // Changing the returned value from the OG method
        return !(boolean) returnedVal;
    }
}
