package start.here.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import start.here.proxies.CommentNotificationProxy;
import start.here.repositories.CommentRepository;

import static start.here.proxies.EmailCommentNotificationProxy.EMAIL_NOTIFICATION_PROXY_NAME;
import static start.here.proxies.PushCommentNotificationProxy.PUSH_NOTIFICATION_PROXY_NAME;

@Service
@Getter
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    @Autowired
    public CommentService(CommentRepository commentRepository, @Qualifier(PUSH_NOTIFICATION_PROXY_NAME) CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
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
