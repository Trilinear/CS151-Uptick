package CRUD;

import java.util.ArrayList;
import java.util.List;

public class PostManager implements Manager{
    public List<Post> postList;

    public PostManager(){
        postList = new ArrayList<>();
    }

    @Override
    public void addObject(Object object) {
        postList.add((Post)object);
    }

    @Override
    public void deleteObject(Object object) {
        postList.remove((Post)object);
    }
}
