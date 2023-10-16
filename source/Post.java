import java.util.Date;



public class Post {
    private final String title;
    private final String body;
    private final Date date;
    private final User user;
    private final int id;

    //Create
    public Post(String title, String body, Date date, User user, int id) {
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

    public Date getUser() {
        return user;
    }

    public int getID() {
        return id;
    }

    //Edit
    public void editTitle(String title, User user) {
        if (this.user == user) {
            this.title = title;
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
    public void deletePost(String title, String body, Date date, User user, int id) {
        this.title = null;
        this.body = null;
        this.date = null;
        this.user = null;
        this.id = -1;
    }


}
