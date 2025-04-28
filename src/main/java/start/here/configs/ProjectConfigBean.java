package start.here.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import start.here.beans.Parrot;
import start.here.beans.Person;

import static start.here.beans.Parrot.PARROT_JAKO_NAME;
import static start.here.beans.Parrot.PARROT_KOKO_NAME;
import static start.here.beans.Person.PERSON_MOMO_NAME;

@Configuration
public class ProjectConfigBean {

    public enum BEAN_NAMES {
        PARROT_KOKO("Parrot Koko Bean"),
        PARROT_JAKO("Parrot Jako Bean");
        public final String name;

        BEAN_NAMES(String name) {
            this.name = name;
        }
    }

//    /** The first way to wire beans (Directly)
//     * */
//    @Bean(PERSON_MOMO_NAME)
//    // The default bean if you didn't specify the bean name you want
//    @Primary
//    Person person() {
//        var person = new Person();
//        person.setName("Momo");
//        person.setParrot(parrot());
//        // When calling the parrot() method spring will look into the Parrot if it exists first;
//        // if it exists spring will NOT create another Parrot BUT it will just assign it to this person,
//        // if it doesn't exist it will create a new parrot
//
//        System.out.printf("Person %s was created%n", person.getName());
//        return person;
//    }

    public static final String MOMO_OWN_PARROT = PARROT_KOKO_NAME;

    /** The second way to wire beans (By Dependency Injection - Using parameters)
     * We ask spring to find a Parrot in the context and then inject it into the method to wire it to this person
     * if there's no bean of type Parrot in the context spring will throw NoSuchBeanDefinitionException
     * if there's multiple beans of type Parrot is will throw NoUniqueBeanDefinitionException
     * */
    @Bean(PERSON_MOMO_NAME)
    // The default bean if you didn't specify the bean name you want
    // We use @Autowired with the old spring versions, couldn't be linked without it in these versions
//    @Primary
    Person person(@Qualifier(MOMO_OWN_PARROT) Parrot p) {
        var person = new Person();
        person.setName("Momo");
        person.setParrot(p);
        // When calling the parrot() method spring will look into the Parrot if it exists first;
        // if it exists spring will NOT create another Parrot BUT it will just assign it to this person,
        // if it doesn't exist it will create a new parrot

        System.out.printf("Person %s was created%n", person.getName());
        return person;
    }

    // @Bean(value = "Parrot koko bean")
    // @Bean(name = PARROT_KOKO_NAME)
    @Bean(PARROT_KOKO_NAME)
//    @Primary
    // The default bean if you didn't specify the bean name you want
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");

        System.out.printf("Parrot %s was created%n", p.getName());
        return p;
    }

    @Bean(PARROT_JAKO_NAME)
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Jako");

        System.out.printf("Parrot %s was created%n", p.getName());
        return p;
    }
}
