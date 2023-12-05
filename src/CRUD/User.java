package CRUD;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class User {
    String username, password;
    Date creationDate;
    List<Post> posts = new ArrayList<Post>();
    List<Comment> comments = new ArrayList<Comment>();
    int karma;


    public User(String username, String password, long userID) {
        this.username = username;
        this.password = password;
        this.creationDate = new Date();
        this.karma = 0;
    }

    public User(String username, String password, long userID, int date) {
        this.username = username;
        this.password = password;
        this.creationDate = new Date(date);
        this.karma = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Date getCreationDate() {return creationDate;}

    public int getKarma() {
        karma = 0;
        for (int i = 0; i < posts.size(); i++){
            karma += posts.get(i).getKarma();
        }
        for (int i = 0; i < comments.size(); i++){
            karma += comments.get(i).getKarma();
        }
        return karma;
    }

    public void editUsername(String password, String username) {
        if (this.password == password) {
            this.username = username;
        } else {
            System.out.println("Wrong password. Edit to username denied.");
        }
    }

    public void editPassword(String currentPassword, String newPassword) {
        if (this.password == currentPassword) {
            this.password = newPassword;
        } else {
            System.out.println("Wrong password. Change to password has been denied.");
        }
    }
}
