package com.example.kozauke.repoviewer.Data;


public class RepoListItem {
    //https://api.github.com/users/marcinkozak-p/repos - this is example currently received from API as a list.
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
