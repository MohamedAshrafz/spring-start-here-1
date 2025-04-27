package start.here.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import start.here.beans.Parrot;

import static start.here.beans.Parrot.PARROT_JAKO_NAME;
import static start.here.beans.Parrot.PARROT_KOKO_NAME;

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

    // @Bean(value = "Parrot koko bean")
    // @Bean(name = PARROT_KOKO_NAME)
    @Bean(PARROT_KOKO_NAME)
    // The default bean if you didn't specify the bean name you want
    @Primary
    Parrot b1() {
        var p = new Parrot();
        p.setName("Koko");

        System.out.printf("Parrot %s was created%n", p.getName());
        return p;
    }

    @Bean(PARROT_JAKO_NAME)
    Parrot b2() {
        var p = new Parrot();
        p.setName("Jako");

        System.out.printf("Parrot %s was created%n", p.getName());
        return p;
    }
}
