package start.here.repositories;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(String comment) {
        System.out.printf("Comment [%s] was saved into the DB\n", comment);
    }
}
