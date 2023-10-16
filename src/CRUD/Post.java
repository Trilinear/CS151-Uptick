package CRUD;
import java.util.Date;



public class Post {
    private String title;
    private String body;
    private Date date;
    private User user;
    private long id;

    //Create
    public Post(String title, String body, Date date, User user, long id) {
        this.title = title;
        this.body = body;
        this.date = date;
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

     public Date getDate() {
        return date;
    }

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
        } else {
            System.out.println("You are not the owner of this post. Edit to title denied.");
        }
    }

    public void editBody(String body, User user) {
        if (this.user == user) {
            this.body = body;
        } else {
            System.out.println("You are not the owner of this post. Edit to body denied.");
        }
    }

    //Delete
    public void deletePost(String title, String body, Date date, User user, long id) {
        this.title = null;
        this.body = null;
        this.date = null;
        this.user = null;
        this.id = -1;
    }


}
