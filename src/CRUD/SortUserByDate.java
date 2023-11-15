package CRUD;

import java.util.Comparator;

public class SortUserByDate implements Comparator<User> {
    public int compare(User a, User b) {
        return a.creationDate.compareTo(b.creationDate);
    }
}
