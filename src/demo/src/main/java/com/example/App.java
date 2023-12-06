package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.io.IOException;



/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    User user1 = new User("user1", "password1", 1, 100);
    User user2 = new User("user2", "password2", 2, 1000000);
    User user3 = new User("user3", "password3", 3);

    Post post1 = new Post("Title 1", "Body 1", user1, 200);
    Post post2 = new Post("Title 2", "Body 2", user2, 1000200);
    Post post3 = new Post("Title 3", "Body 3", user1);

    Comment comment1 = new Comment("Comment 1", user2, post1, 300);
    Comment comment2 = new Comment("Comment 2", user2, post1, 1000700);
    Comment comment3 = new Comment("Comment 3", user1, post2);


    PostManager postManager = new PostManager();
    PostManager commentManager = new PostManager();
    UserManager userManager = new UserManager();

    public void initiateList() {

        userManager.addObject(user1);
        userManager.addObject(user2);
        userManager.addObject(user3);

        postManager.addObject(post1);
        postManager.addObject(post2);
        postManager.addObject(post3);

        commentManager.addObject(comment1);
        commentManager.addObject(comment2);
        commentManager.addObject(comment3);
    }
    ListView<Post> PostView = new ListView<Post>();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        initiateList();
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}