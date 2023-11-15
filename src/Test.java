import java.util.Collections;
import java.util.Scanner;
import CRUD.*;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        User user1 = new User("user1", "password1", 1);
        User user2 = new User("user2", "password2", 2);
        System.out.println("User 1: " + user1.getUsername());
        System.out.println("User 2: " + user2.getUsername());

        Post post1 = new Post("Title 1", "Body 1", user1);
        Post post2 = new Post("Title 2", "Body 2", user2);
        Post post3 = new Post("Title 3", "Body 3", user1);

        System.out.println("Post 1 Title: " + post1.getTitle());
        System.out.println("Post 1 Body: " + post1.getBody());

        System.out.println("Post 2 Title: " + post2.getTitle());
        System.out.println("Post 2 Body: " + post2.getBody());

        System.out.println("Post 3 Title: " + post3.getTitle());
        System.out.println("Post 3 Body: " + post3.getBody());

        Comment comment1 = new Comment("Comment 1", user2, post1);
        System.out.println("Comment 1 Body: " + comment1.getBody());

        PostManager postManager = new PostManager();
        UserManager userManager = new UserManager();

        userManager.addObject(user1);
        userManager.addObject(user2);
        postManager.addObject(post1);
        postManager.addObject(post2);
        postManager.addObject(post3);

        post1.editTitle("New Title", user1);
        comment1.editText("New Comment Body");
        System.out.println("Post 1 New Title: " + post1.getTitle());
        System.out.println("Comment 1 New Body: " + comment1.getBody());

        userManager.deleteObject(user1);
        postManager.deleteObject(post1);
        System.out.println("Users count after deletion: " + userManager.userList.size());
        System.out.println("Posts count after deletion: " + postManager.postList.size());
            
        postManager.sortByDate();

        for (Post post : postManager.postList) {
            System.out.println("Post Title: " + post.getTitle());
            System.out.println("Post Body: " + post.getBody());
            System.out.println("Creation Time: " + post.getCreationDate());
        }
    }
}
