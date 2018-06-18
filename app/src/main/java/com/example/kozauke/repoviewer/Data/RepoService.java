package com.example.kozauke.repoviewer.Data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RepoService {

    public void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.example.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
