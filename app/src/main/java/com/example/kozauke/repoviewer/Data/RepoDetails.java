package com.example.kozauke.repoviewer.Data;

import android.arch.lifecycle.MutableLiveData;

public class RepoDetails extends MutableLiveData<RepoDetails> {

    //TODO: dać więcej iinfo
    //Example: https://api.github.com/repos/marcinkozak-p/AndroidTask_ab
    public String name = "NULL";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
