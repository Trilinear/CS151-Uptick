package CRUD;

import java.util.Comparator;

public class SortPostByDate implements Comparator<Post> {
    public int compare(Post a, Post b) {
        return a.creationDate.compareTo(b.creationDate);
    }
}
