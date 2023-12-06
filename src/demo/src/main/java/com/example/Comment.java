package com.example;
import java.util.Date;

public class Comment extends Post{
    Post parent;

    public Comment(String text, User user, Post parent) {
        super(null, text, user);
        this.parent = parent;
    }

    public Comment(String text, User user, Post parent, int date) {
        super(null, text, user, date);
        this.parent = parent;
    }
    
    public Post getPost() {
        return parent;
    }

    public void editText(String newText) {
        this.body = newText;
        this.editDate = new Date();
    }
}
