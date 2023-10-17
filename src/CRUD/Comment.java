package CRUD;
import java.util.Date;

public class Comment extends Post{
    Post parent;

    public Comment(String text, User user, Post parent) {
        super(null, text, user);
        this.parent = parent;
    }

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return parent;
    }

    public String getBody() {
        return body;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() { return editDate; }

    public void editText(String newText) {
        this.body = newText;
        this.editDate = new Date();
    }
    
    public void deleteComment() {
        this.body = null;
        this.creationDate = null;
        this.editDate = null;
        this.parent = null;
    }
}
