package com.example;

import javafx.fxml.FXML;

import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;

public class HomePageController {

    @FXML
    private Button CreatePostButton;

    @FXML
    private Button DeletePostButton;

    @FXML
    private Button EditPostButton;

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
    private ListView<String> PostListView;

    @FXML
    void CreatePostPressed() {
    }

    @FXML
    void DeletePostPressed() {
        CreatePostButton.setOnAction(event -> {
            ObservableList<Integer> selectedIndices = PostListView.getSelectionModel().getSelectedIndices();

            for (Object o : selectedIndices) {
                int index = PostListView.getItems().indexOf(o);
                postManager.deleteObject(index);
            }
            showPage();
        });
    }

    @FXML
    void EditPostPressed() {
        Post newPost = new Post("Edited Post 4","Edited Body 4", user1);
    }

    @FXML
    void OpenCommentPressed() {

    }

    @FXML
    void OpenPostPressed() {

    }

    @FXML
    void SortDatePressed() {
        postManager.sortByDate();
        showPage();
    }

    @FXML
    void SortKarmaPressed() {
        postManager.sortByKarma();
        showPage();
    }

    @FXML
    void openUserPage() {

    }

    @FXML
    void UpvotePressed() {
        userManager.upvote(user1, post1);
    }

    @FXML
    void DownvotePressed() {
        userManager.downvote(user1, post1);
    }
    private ListView<Post> currentPosts = new ListView<Post>();
    @FXML
    private void showPage() {
        if (PostListView.getItems().isEmpty() == true || currentPosts.getItems().isEmpty() == true) {
            initiateList();

        } else {
            PostListView = new ListView<String>();
            currentPosts = new ListView<Post>();
        }

        for (Post post : postManager.postList) {
            PostListView.getItems().add(post.getTitle() + " Karma: " + post.getKarma());
        }

        for (Post post : postManager.postList) {
            currentPosts.getItems().add(post);
        }
    }

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
}
