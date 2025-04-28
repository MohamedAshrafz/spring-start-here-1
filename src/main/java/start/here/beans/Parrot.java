package start.here.beans;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
public class Parrot {

    public static final String PARROT_KOKO_NAME = "Parrot Koko Bean";
    public static final String PARROT_JAKO_NAME = "Parrot Jako Bean";

    private String name;

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
