package CRUD;
import java.util.Comparator;
import java.util.Date;

public class Post implements Comparator<Post> {
    private String title, body;
    private Date creationDate, editDate;
    private User user;
    private long id;

    //Create
    public Post(String title, String body, User user, long id) {
        this.title = title;
        this.body = body;
        this.creationDate = new Date();
        this.editDate = creationDate;
        this.user = user;
        this.id = id;
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

    public long getID() {
        return id;
    }

    //Edit
    public void editTitle(String newTitle, User user) {
        if (this.user == user) {
            this.title = newTitle;
            this.editDate = new Date();
        } else {
            System.out.println("You are not the owner of this post. Edit to title denied.");
        }
    }

    public void editBody(String body, User user) {
        if (this.user == user) {
            this.body = body;
            this.editDate = new Date();
        } else {
            System.out.println("You are not the owner of this post. Edit to body denied.");
        }
    }

    //Delete
    public void deletePost(String title, String body, Date date, User user, long id) {
        this.title = null;
        this.body = null;
        this.creationDate = null;
        this.editDate = null;
        this.user = null;
        this.id = -1;
    }

    @Override
    public int compare(Post p1, Post p2){
        return p1.getCreationDate().compareTo(p2.getCreationDate());
    }
}
