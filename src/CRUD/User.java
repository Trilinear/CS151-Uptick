package CRUD;
import java.util.List;

public class User {
    String username, password;
    List<Post> posts;
    List<Comment> comments;


    public User(String username, String password, long userID) {
        this.username = username;
        this.password = password;
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
}
