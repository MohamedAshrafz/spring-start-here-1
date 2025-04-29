package start.here.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static start.here.proxies.PushCommentNotificationProxy.PUSH_NOTIFICATION_PROXY_NAME;

@Component
@Qualifier(PUSH_NOTIFICATION_PROXY_NAME)
public class PushCommentNotificationProxy implements CommentNotificationProxy {

    public static final String PUSH_NOTIFICATION_PROXY_NAME = "pushNotificationProxy";

    @Override
    public void sendComment(String comment) {
        System.out.printf("Comment [%s] was send by push notification\n", comment);
    }
}
