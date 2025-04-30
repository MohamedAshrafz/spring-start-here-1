package start.here.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import start.here.BeansNames;


// Seems like you can add the name on the @Bean/@Component or on the @Qualifier
@Component(BeansNames.EMAIL_NOTIFICATION_PROXY_NAME)
//@Qualifier(BeansNames.EMAIL_NOTIFICATION_PROXY_NAME)
public class EmailCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(String comment) {
        System.out.printf("Comment [%s] was send by Email\n", comment);
    }

    public EmailCommentNotificationProxy() {
        System.out.println("Creating EmailCommentNotificationProxy class.");
    }
}
