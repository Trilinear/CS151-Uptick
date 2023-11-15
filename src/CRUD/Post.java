package CRUD;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post{
    String title, body;
    Date creationDate, editDate;
    User user;
    int karma;
    List<User> upvoted, downvoted;

    //Create
    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.creationDate = new Date();
        this.editDate = creationDate;
        this.user = user;
        this.karma = 0;
        this.upvoted = new ArrayList<>();
        this.downvoted = new ArrayList<>();
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

    public int getKarma() { return karma; }

    public List<User> getUpvoted() { return upvoted; }

    public List<User> getDownvoted() { return downvoted; }

    //Edit
    public void editTitle(String newTitle, User user) {
        this.title = newTitle;
        this.editDate = new Date();
    }

    public void editBody(String body, User user) {
        this.body = body;
        this.editDate = new Date();
    }
}