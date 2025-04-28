package start.here.beans;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Getter
public class Person {

    public static final String PERSON_MOMO_NAME = "PERSON_MOMO_BEAN";

    private String name;

//    /**
//     * First way of using {@link Autowired}<br>
//     * Injecting the value (the bean) in the <b>FIELD</b> of the owner bean class<br>
//     * <b>You CANNOT use final in this case</b>
//     */
//    @Autowired
    private Parrot parrot;

    public void setName(String name) {
        this.name = name;
    }

        /**
     * Second way of using {@link Autowired}<br>
     * Injecting the value (the bean) in the <b>SETTER</b> field of the owner bean class<br>
     * <b>You CANNOT use final in this case</b>
     */
//    @Autowired
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

//    /**
//     * Third and the preferred way of using {@link Autowired}<br>
//     * Injecting the value in (the bean) in the <b>CONSTRUCTOR</b> of the owner bean class,<br>
//     * <b><u>Note 1:</u> This method only makes sense when using prototype initializing because of java</b><br>
//     *
//     * <u>Note 2:</u> you can omit the {@link Autowired} annotation when there is a single constructor in the bean
//     * when using a recent version of spring<br>
//     * <b>You CAN use final in this case</b>
//     */
//    @Autowired
//    public Person(Parrot parrot) {
//        this.parrot = parrot;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}














