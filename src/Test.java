import java.util.Collections;
import java.util.Scanner;
import CRUD.*;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        User user1 = new User("user1", "password1", 1);
        User user2 = new User("user2", "password2", 2);
        User user3 = new User("user3", "password3", 3);
        // System.out.println("User 1: " + user1.getUsername());
        // System.out.println("User 2: " + user2.getUsername());

        Post post1 = new Post("Title 1", "Body 1", user1);
        Post post2 = new Post("Title 2", "Body 2", user2);
        Post post3 = new Post("Title 3", "Body 3", user1);

        // System.out.println("Post 1 Title: " + post1.getTitle());
        // System.out.println("Post 1 Body: " + post1.getBody());

        // System.out.println("Post 2 Title: " + post2.getTitle());
        // System.out.println("Post 2 Body: " + post2.getBody());

        // System.out.println("Post 3 Title: " + post3.getTitle());
        // System.out.println("Post 3 Body: " + post3.getBody());

        Comment comment1 = new Comment("Comment 1", user2, post1);
        // System.out.println("Comment 1 Body: " + comment1.getBody());

        Comment comment3 = new Comment("Comment 3", user1, post2);
        // System.out.println("Comment 2 Body: " + comment3.getBody());

        Comment comment2 = new Comment("Comment 2", user2, post1);
        // System.out.println("Comment 2 Body: " + comment2.getBody());


        PostManager postManager = new PostManager();
        PostManager postManager2 = new PostManager();
        UserManager userManager = new UserManager();

        userManager.addObject(user1);
        userManager.addObject(user2);
        userManager.addObject(user3);

        postManager.addObject(post1);
        postManager.addObject(post2);
        postManager.addObject(post3);

        postManager2.addObject(comment1);
        postManager2.addObject(comment2);
        postManager2.addObject(comment3);

        post1.editTitle("New Title", user1);
        comment1.editText("New Comment 1");
        System.out.println("Post 1 New Title: " + post1.getTitle());
        System.out.println("Comment 1 New Body: " + comment1.getBody());

        userManager.deleteObject(user1);
        postManager.deleteObject(post1);
        System.out.println("Users count after deletion: " + userManager.userList.size());
        System.out.println("Posts count after deletion: " + postManager.postList.size());
            
        user3.downvote(post3);
        user2.upvote(post3);
        user3.upvote(post2);
        user2.upvote(post2);
        // This is a problem, user1 can still upvote post1 even though its a deleted user
        user1.upvote(post1);
        // You can also up/downvote a deleted post, although this isn't as big of a problem since
        // we aren't really ever accessing the post through our manager
        user2.downvote(post1);





        postManager.sortByDate();
        userManager.sortByDate();
        postManager2.sortByDate();

        for (Post post : postManager.postList) {
            System.out.println("Post Title: " + post.getTitle());
            System.out.println("Post Body: " + post.getBody());
            System.out.println("Creation Time: " + post.getCreationDate());
            System.out.println("Karma: " + post.getKarma());
        }

        for (User user : userManager.userList) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("User Karma: " + user.getKarma());
            System.out.println("Creation Time: " + user.getCreationDate());
        }

        for (Post comment : postManager2.postList) {
            System.out.println("Comment: " + comment.getBody());
            System.out.println("Creation Time: " + comment.getCreationDate());
            System.out.println("Karma: " + comment.getKarma());
        }

        postManager.sortByKarma();
        userManager.sortByKarma();
        postManager2.sortByKarma();

        for (Post post : postManager.postList) {
            System.out.println("Post Title: " + post.getTitle());
            System.out.println("Post Body: " + post.getBody());
            System.out.println("Creation Time: " + post.getCreationDate());
        }

        for (User user : userManager.userList) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("User Karma: " + user.getKarma());
            System.out.println("Creation Time: " + user.getCreationDate());
        }

        for (Post comment : postManager2.postList) {
            System.out.println("Comment: " + comment.getBody());
            System.out.println("Creation Time: " + comment.getCreationDate());
        }
    }
}
