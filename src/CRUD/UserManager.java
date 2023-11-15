package CRUD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserManager implements Manager{
    public List<User> userList;

    public UserManager(){
        userList = new ArrayList<>();
    }

    @Override
    public void addObject(Object object) {
        userList.add((User)object);
    }

    @Override
    public void deleteObject(Object object) {
        userList.remove((User)object);
    }

    @Override
    public void sortByDate() {
        Collections.sort(userList, new SortUserByDate());
    }

    @Override
    public void sortByKarma() {
        Collections.sort(userList, new SortUserByKarma());
    }
}
