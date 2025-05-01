package start.here.proxies;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import start.here.BeansNames;

// Seems like you can add the name on the @Bean/@Component or on the @Qualifier
@Component(BeansNames.PUSH_NOTIFICATION_PROXY_NAME)
//@Qualifier(BeansNames.PUSH_NOTIFICATION_PROXY_NAME)
//@Scope(BeanDefinition.SCOPE_PROTOTYPE) // Creates the bean in the Prototype scope instead of the default Singleton scope
public class PushCommentNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(String comment) {
        System.out.printf("Comment [%s] was send by push notification\n", comment);
    }

    public PushCommentNotificationProxy() {
        System.out.println("Creating PushCommentNotificationProxy class.");
    }
}
