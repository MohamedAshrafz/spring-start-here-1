package start.here.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"start.here.services", "start.here.repositories", "start.here.proxies", "start.here.aspects"})
@EnableAspectJAutoProxy // Enables Aspects
public class ProjectConfigStereotype {

}
