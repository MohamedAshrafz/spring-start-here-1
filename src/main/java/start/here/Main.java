package start.here;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import start.here.beans.Parrot;
import start.here.beans.Person;
import start.here.configs.ProjectConfigBean;

import java.util.function.Supplier;

import static start.here.beans.Parrot.PARROT_JAKO_NAME;
import static start.here.beans.Parrot.PARROT_KOKO_NAME;
import static start.here.beans.Person.PERSON_MOMO_NAME;

public class Main {
    public static void main(String[] args) {
        // Bean Annotation
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfigBean.class);

        // You cannot define multiple beans from the same type(class), If you tried you will get an exception
        // If you have @Primary above a bean it will be returned(when multiple beans of the same type exist)

        Parrot parrot;
        Person person;

        System.out.println(parrot = context.getBean(Parrot.class));
        System.out.println(person = context.getBean(PERSON_MOMO_NAME, Person.class));

        System.out.printf("Is the same parrot? %b", person.getParrot() == parrot);

//        // Stereotype Annotation
//        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfigStereotype.class);
//
//        System.out.println(context.getBean(Parrot.class));

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