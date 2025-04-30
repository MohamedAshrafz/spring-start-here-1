package start.here.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import start.here.proxies.CommentNotificationProxy;
import start.here.repositories.CommentRepository;

import static start.here.proxies.EmailCommentNotificationProxy.EMAIL_NOTIFICATION_PROXY_NAME;
import static start.here.proxies.PushCommentNotificationProxy.PUSH_NOTIFICATION_PROXY_NAME;

@Service
@Getter
@Lazy // Will delay bean creation till when it's needed
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    @Autowired
    public CommentService(CommentRepository commentRepository, @Qualifier(PUSH_NOTIFICATION_PROXY_NAME) CommentNotificationProxy commentNotificationProxy) {
        System.out.println("Start creating CommentService class.");
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finish creating CommentService class.");
    }

    public void submitComment(String comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

        System.out.printf("comment [%s] was submitted successfully\n", comment);
    }

    @Override
    public String toString() {
        return "CommentService{" +
                "commentRepository=" + commentRepository +
                ", commentNotificationProxy=" + commentNotificationProxy +
                '}';
    }
}
