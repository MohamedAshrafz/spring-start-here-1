package start.here.beans;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
@AllArgsConstructor
@ToString
public class PersonAb {

    private final Parrot parrot;
}
