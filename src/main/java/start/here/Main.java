package start.here;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        System.out.println(context.getBean(Parrot.class));
        System.out.println(context.getBean(Parrot.class));
        System.out.println(context.getBean(Parrot.class));
    }
}