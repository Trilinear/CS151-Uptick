package com.example.CRUD;

import java.util.Comparator;

public class SortUserByKarma implements Comparator<User> {
    public int compare(User a, User b) {
        return b.getKarma() - a.getKarma();
    }
}