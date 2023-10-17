package CRUD;
import java.util.List;

public class User {
    private String username, password;
    private long userID;
    private List<Post> posts;
    private List<Comment> comments;


    public User(String username, String password, long userID) {
        this.username = username;
        this.password = password;
        this.userID = userID;
    }

    public long getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    private List<Post> getPosts() {
        return posts;
    }

    private List<Comment> getComments() {
        return comments;
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
    public void deleteUser(String username, String password, long userID) {
        this.username = null;
        this.password = null;
        this.userID = -1;
    }
}
