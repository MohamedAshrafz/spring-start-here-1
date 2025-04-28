package start.here.beans;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Getter
public class Person {

    public static final String PERSON_MOMO_NAME = "PERSON_MOMO_BEAN";

    private String name;
    private Parrot parrot;

    public void setName(String name) {
        this.name = name;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}














