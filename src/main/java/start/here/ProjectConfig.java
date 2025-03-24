package start.here;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot Koko() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }
}

class Parrot{
    public String name;

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

}
