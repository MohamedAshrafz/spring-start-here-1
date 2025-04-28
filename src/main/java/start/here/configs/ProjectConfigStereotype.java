package start.here.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import start.here.beans.Parrot;
import start.here.beans.Person;

import static start.here.beans.Parrot.PARROT_KOKO_NAME;

@Configuration
@ComponentScan(basePackages = {"start.here.beans", "start.here.services"})
public class ProjectConfigStereotype {

    // @Bean(value = "Parrot koko bean")
    // @Bean(name = PARROT_KOKO_NAME)
    @Bean(PARROT_KOKO_NAME)
    @Primary
    // The default bean if you didn't specify the bean name you want
    Parrot parrot() {
        var parrot = new Parrot();
        parrot.setName("Koko");

        System.out.printf("Parrot %s was created%n", parrot.getName());
        return parrot;
    }

//    @Bean
//    Person person() {
//        var person = new Person();
//        person.setName("Momo");
//
//        System.out.printf("Person %s was created%n", person.getName());
//        return person;
//    }
}
