package start.here;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import start.here.configs.ProjectConfigStereotype;
import start.here.proxies.CommentNotificationProxy;
import start.here.services.CommentService;

import static start.here.proxies.EmailCommentNotificationProxy.EMAIL_NOTIFICATION_PROXY_NAME;
import static start.here.proxies.PushCommentNotificationProxy.PUSH_NOTIFICATION_PROXY_NAME;

public class Main {
    public static void main(String[] args) {
        // Bean Annotation
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfigStereotype.class);

        System.out.println(":D");

        CommentService commentService = context.getBean(CommentService.class);
        CommentNotificationProxy commentNotificationProxy = context.getBean(PUSH_NOTIFICATION_PROXY_NAME, CommentNotificationProxy.class);

        commentService.submitComment("Hi there from the other side of the universe :)");

        System.out.printf("is the same bean commentNotificationProxy? [%b]\n",
                commentService.getCommentNotificationProxy() == commentNotificationProxy);



//        // Stereotype Annotation
//        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfigStereotype.class);
//
//        Parrot parrot;
//        Person person;
//
//        System.out.println(parrot = context.getBean(Parrot.class));
//        System.out.println(person = context.getBean(Person.class));
//
//        System.out.printf("Is the same parrot? %b", person.getParrot() == parrot);

//        // Lombok Stereotype Annotation
//        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfigStereotype.class);
//
//        Parrot parrot;
//        PersonAb person;
//
//        System.out.println(parrot = context.getBean(Parrot.class));
//        System.out.println(person = context.getBean(PersonAb.class));
//
//        System.out.printf("Is the same parrot? %b", person.getParrot() == parrot);

//        // Adding a bean programmatically
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//
//        Parrot p = new Parrot();
//        p.setName("mahmoud");
//
//        Supplier<Parrot> parrotSupplier = () -> p;
//        context.registerBean("mahmoud bean", Parrot.class, parrotSupplier);
//
//        // The context needs to be refreshed first before you can get the bean registered
//        context.refresh();
//
//        System.out.println(context.getBean(Parrot.class));
    }
}