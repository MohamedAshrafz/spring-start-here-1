package start.here.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static start.here.proxies.EmailCommentNotificationProxy.EMAIL_NOTIFICATION_PROXY_NAME;

// Seems like you can add the name on the @Bean/@Component or on the @Qualifier
@Component(EMAIL_NOTIFICATION_PROXY_NAME)
//@Qualifier(EMAIL_NOTIFICATION_PROXY_NAME)
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    public static final String EMAIL_NOTIFICATION_PROXY_NAME = "emailNotificationProxy";

    @Override
    public void sendComment(String comment) {
        System.out.printf("Comment [%s] was send by Email\n", comment);
    }

    public EmailCommentNotificationProxy() {
        System.out.println("Creating EmailCommentNotificationProxy class.");
    }
}
