package start.here;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import start.here.configs.ProjectConfigStereotype;
import start.here.services.CommentService;

public class Main {
    public static void main(String[] args) {
        // Bean Annotation
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfigStereotype.class);

        System.out.println(":D");

        CommentService commentService = context.getBean(CommentService.class);

        commentService.publishComment("Hi there");
        commentService.deleteComment("Hi there");
        commentService.editComment("Hi there");
    }
}