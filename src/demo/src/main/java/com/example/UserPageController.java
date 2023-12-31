package com.example;

import java.io.IOException;

import com.example.CRUD.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class UserPageController {

    @FXML
    private Pane UserPagePane;

    @FXML
    private Button CreateUserButton;

    @FXML
    private Button DeleteUserButton;

    @FXML
    private Button EditUserButton;

    @FXML
    private Button OpenCommentButton;

    @FXML
    private Button OpenUserButton;

    @FXML
    private Button OpenPostButton;

    @FXML
    private Button Refresh;

    @FXML
    private Button SortDateButton;

    @FXML
    private Button SortKarmaButton;

    @FXML
    private Button UpvoteButton;

    @FXML
    private Button DownvoteButton;

    @FXML
    private ListView<String> UserListView;

    @FXML
    private TextField bodyTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField titleTextField;

    private boolean isStarted = false;

    int index;

    User user1 = new User("user1", "password1", 1, 100);
    public User currentUser = user1;
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
    @FXML
    void CreateUserPressed() {
        User newUser = new User("new user", "new password", 4);
        userManager.addObject(newUser);
        System.out.println("new user created");
        showPage();
    }

    @FXML
    void DeleteUserPressed(MouseEvent event) {
        String selectedPost = UserListView.getSelectionModel().getSelectedItem();
        int index = UserListView.getItems().indexOf(selectedPost);
        userManager.userList.remove(index);
        UserListView.getItems().remove(index);
        currentUsers.getItems().remove(index);
        showPage();
    }

    @FXML
    void EditUserPressed() throws IOException {
        String selectedPost = UserListView.getSelectionModel().getSelectedItem();
        int index = UserListView.getItems().indexOf(selectedPost);
        System.out.println(index);
        if (!userManager.userList.get(index).getUsername().equals(currentUser.getUsername())) {
            Pane pane = new Pane();
            Text text = new Text("Not allowed, you are not the correct user");
            text.setTranslateX(100);
            text.setTranslateY(100);
            text.setTextAlignment(TextAlignment.CENTER);
            Scene scene = new Scene(pane, 400, 200);
            pane.getChildren().add(text);
            // Set the stage title and scene, then show the stage
            Stage stage = new Stage();
            stage.setTitle("Not Allowed");
            stage.setScene(scene);
            stage.show();
        } else {
            userManager.userList.get(index).editUsername(userManager.userList.get(index).getPassword(),"new " +
                    userManager.userList.get(index).getUsername());
        }
        showPage();
    }

    @FXML
    private void confirmButtonPressed() throws IOException {
        String newTitle = titleTextField.getText();
        String newBody = bodyTextField.getText();

        System.out.println("Pressed");
        App.setRoot("HomePage");

        if (!newTitle.isEmpty()) {
            postManager.postList.get(index).editTitle(newTitle, currentUser);
        }

        if (!newBody.isEmpty()) {
            postManager.postList.get(index).editBody(newBody, currentUser);
        }
    }

    @FXML
    void openUserPressed() {

    }

    @FXML
    void OpenPostPressed() throws IOException {
        App.setRoot("HomeView");
        isStarted = false;
    }

    @FXML
    void OpenCommentPressed() throws IOException {
        App.setRoot("CommentPage");
        isStarted = false;
    }

    @FXML
    void SortDatePressed() {
        userManager.sortByDate();
        showPage();
    }

    @FXML
    void SortKarmaPressed() {
        userManager.sortByKarma();
        showPage();
    }

    @FXML
    void UpvotePressed() {
        String selectedPost = UserListView.getSelectionModel().getSelectedItem();
        int index = UserListView.getItems().indexOf(selectedPost);

        userManager.upvote(currentUser, postManager.postList.get(index));
        showPage();
    }

    @FXML
    void DownvotePressed() {
        String selectedPost = UserListView.getSelectionModel().getSelectedItem();
        int index = UserListView.getItems().indexOf(selectedPost);

        userManager.downvote(currentUser, postManager.postList.get(index));
        showPage();

    }
    private ListView<User> currentUsers = new ListView<User>();
    @FXML
    private void showPage() {
        if (isStarted == false) {
            initiateList();
            isStarted = true;
        }

        for (User user : userManager.userList) {
            System.out.println(user.getUsername());
        }
        if (!UserListView.getItems().isEmpty()) {
            for (User user : currentUsers.getItems()) {
                UserListView.getItems().remove(0);
            }
        }

        for (User user : userManager.userList) {
            UserListView.getItems().add("Username: " + user.getUsername() + " Karma: " + user.getKarma());
        }

        for (User user : userManager.userList) {
            if (!currentUsers.getItems().contains(user)) {
                currentUsers.getItems().add(user);
            }
        }
    }
}