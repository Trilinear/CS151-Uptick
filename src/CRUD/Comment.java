package CRUD;
import java.util.Comparator;
import java.util.Date;

public class Comment implements Comparator<Comment> {
    private long commentID;
    private User author;
    private Post post;
    private String text;
    private Date creationDate, editDate;

    public Comment(User author, Post post, String text, long commentID, Date creationDate) {
        this.author = author;
        this.post = post;
        this.text = text;
        this.commentID = commentID;
        this.creationDate = new Date();
        this.editDate = creationDate;
    }

    public long getCommentID() {
        return commentID;
    }

    public User getUser() {
        return author;
    }

    public Post getPost() {
        return post;
    }

    public String getText() {
        return text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() { return editDate; }

    public void editText(String newText, User user) {
        if (this.author == user) {
            this.text = newText;
            this.editDate = new Date();
        } else {
            System.out.println("This user is not the owner of the comment. Changes prevented.");
        }
    }
    
    public void deleteComment(User user, Post post, String text, long commentID, Date creationDate) {
        if (this.author == user && this.post == post) {
            this.text = null;
            this.commentID = -1;
            this.creationDate = null;
            this.editDate = null;
        }
    }

    @Override
    public int compare(Comment c1, Comment c2){
        return c1.getCreationDate().compareTo(c2.getCreationDate());
    }
}
