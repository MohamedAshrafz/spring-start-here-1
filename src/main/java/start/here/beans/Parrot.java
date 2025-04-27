package start.here.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;


public class Parrot {

    public static final String PARROT_KOKO_NAME = "Parrot Koko Bean";
    public static final String PARROT_JAKO_NAME = "Parrot Jako Bean";

    // Only needed in the stereotype annotations
//    @PostConstruct
//    void init() {
//        this.name = "Koko";
//    }
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
                "name='" + name + "', " +
                "hashCode='" + Integer.toHexString(hashCode()) + '\'' +
                '}';
    }
}
