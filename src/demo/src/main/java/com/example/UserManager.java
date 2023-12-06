package com.example;

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

    public void upvote(User user, Post post){
        if (!userList.contains(user)){
            System.out.println(user.getUsername() + " is not in the list");
            return;
        }
        if (post.getUpvoted().contains(user)){
            post.getUpvoted().remove(user);
            post.karma--;
            return;
        }
        if (post.getDownvoted().contains(user)){
            post.getDownvoted().remove(user);
            post.karma++;
        }
        post.getUpvoted().add(user);
        post.karma++;
    }

    public void downvote(User user,Post post){
        if (!userList.contains(user)){
            System.out.println(user.getUsername() + " is not in the list");
            return;
        }
        if (post.getDownvoted().contains(user)){
            post.getDownvoted().remove(user);
            post.karma++;
            return;
        }
        if (post.getUpvoted().contains(user)){
            post.getUpvoted().remove(user);
            post.karma--;
        }
        post.getDownvoted().add(user);
        post.karma--;
    }
}
