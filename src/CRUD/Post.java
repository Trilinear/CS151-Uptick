package CRUD;
import java.util.Comparator;
import java.util.Date;

public class Post implements Comparator<Post> {
    String title, body;
    Date creationDate, editDate;
    User user;

    //Create
    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.creationDate = new Date();
        this.editDate = creationDate;
        this.user = user;
    }

    //Read
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() { return editDate; }

    public User getUser() {
        return user;
    }

    //Edit
    public void editTitle(String newTitle, User user) {
        this.title = newTitle;
        this.editDate = new Date();
    }

    public void editBody(String body, User user) {
        this.body = body;
        this.editDate = new Date();
    }

    //Delete
    public void deletePost() {
        this.title = null;
        this.body = null;
        this.creationDate = null;
        this.editDate = null;
        this.user = null;
    }

    @Override
    public int compare(Post p1, Post p2){
        return p1.getCreationDate().compareTo(p2.getCreationDate());
    }
}
