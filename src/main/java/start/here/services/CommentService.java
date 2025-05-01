package start.here.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import start.here.AppUtils;
import start.here.aspects.ToLog;

import java.util.logging.Logger;

@Service
@Getter
@Lazy // Will delay bean creation till when it's needed
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());


    public void publishComment(String comment) {
        logger.info("Publishing comment:" + comment);
    }

    @ToLog
    public void deleteComment(String comment) {
        logger.info("Deleting comment:" + comment);
    }

    public void editComment(String comment) {
        logger.info("Editing comment:" + comment);
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
