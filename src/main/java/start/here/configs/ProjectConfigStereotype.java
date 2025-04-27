package start.here.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import start.here.beans.Parrot;

@Configuration
@ComponentScan(basePackages = {"start.here.beans", "start.here.services"})
public class ProjectConfigStereotype {


}
