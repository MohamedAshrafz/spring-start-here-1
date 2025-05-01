package start.here.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import start.here.AppUtils;
import start.here.proxies.CommentNotificationProxy;
import start.here.repositories.CommentRepository;

import java.util.logging.Logger;

@Service
@Getter
@Lazy // Will delay bean creation till when it's needed
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    @Autowired
    public CommentService(CommentRepository commentRepository, @Qualifier(AppUtils.CURRENT_NOTIFICATION_PROXY) CommentNotificationProxy commentNotificationProxy) {
//        System.out.println("Start creating CommentService class.");
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Finish creating CommentService class.");
    }

    public boolean submitComment(String comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

//        logger.info("submitting the comment: [" + comment + "]");
        return false;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String toString() {
        return "CommentService{" +
                "commentRepository=" + commentRepository +
                ", commentNotificationProxy=" + commentNotificationProxy +
                '}';
    }
}
