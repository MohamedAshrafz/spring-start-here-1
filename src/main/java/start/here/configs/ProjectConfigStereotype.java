package start.here.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"start.here.services", "start.here.repositories", "start.here.proxies"})
public class ProjectConfigStereotype {

}
