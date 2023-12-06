package com.example;

import java.util.Comparator;

public class SortPostByKarma implements Comparator<Post> {
    public int compare(Post a, Post b) {
        return b.karma - a.karma;
    }
}