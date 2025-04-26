package start.here;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    public enum BEAN_NAMES {
        PARROT_KOKO("Parrot Koko Bean"),
        PARROT_JAKO("Parrot Jako Bean");
        public final String name;

        BEAN_NAMES(String name) {
            this.name = name;
        }
    }

    public static final String PARROT_KOKO_NAME = "Parrot Koko Bean";
    public static final String PARROT_JAKO_NAME = "Parrot Jako Bean";

    //    @Bean(value = "Parrot koko bean")
//    @Bean(name = PARROT_KOKO_NAME)
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

class Parrot {
    private String name;

    public Parrot() {
        name = "No name provided";
    }

    public Parrot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
