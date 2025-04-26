package start.here;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static start.here.ProjectConfig.PARROT_JAKO_NAME;
import static start.here.ProjectConfig.PARROT_KOKO_NAME;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

//        System.out.println(context.getBean(Parrot.class));

        // You cannot define multiple beans from the same type(class), If you tried you will get an exception
        // If you have @Primary above a bean it will be returned(when multiple beans of the same type exist)
        System.out.println(context.getBean(Parrot.class));

        /**
         To get the beans you want, you need to specify which one using the <b>bean name</b>
         **/

        System.out.println(context.getBean(PARROT_KOKO_NAME, Parrot.class));
        System.out.println(context.getBean(PARROT_JAKO_NAME, Parrot.class));
    }
}