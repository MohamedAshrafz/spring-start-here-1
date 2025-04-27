package start.here;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import start.here.beans.Parrot;
import start.here.configs.ProjectConfigBean;
import start.here.configs.ProjectConfigStereotype;

import java.util.function.Supplier;

import static start.here.beans.Parrot.PARROT_JAKO_NAME;
import static start.here.beans.Parrot.PARROT_KOKO_NAME;

public class Main {
    public static void main(String[] args) {
//        // Bean Annotation
//        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfigBean.class);
//
//        // You cannot define multiple beans from the same type(class), If you tried you will get an exception
//        // If you have @Primary above a bean it will be returned(when multiple beans of the same type exist)
//        System.out.println(context.getBean(Parrot.class));
//
//        /**
//         To get the beans you want, you need to specify which one using the <b>bean name</b>
//         **/
//
//        System.out.println(context.getBean(PARROT_KOKO_NAME, Parrot.class));
//        System.out.println(context.getBean(PARROT_JAKO_NAME, Parrot.class));

//        // Stereotype Annotation
//        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfigStereotype.class);
//
//        System.out.println(context.getBean(Parrot.class));

        // Adding a bean programmatically
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        Parrot p = new Parrot();
        p.setName("mahmoud");

        Supplier<Parrot> parrotSupplier = () -> p;
        context.registerBean("mahmoud bean", Parrot.class, parrotSupplier);

        // The context needs to be refreshed first before you can get the bean registered
        context.refresh();

        System.out.println(context.getBean(Parrot.class));
    }
}