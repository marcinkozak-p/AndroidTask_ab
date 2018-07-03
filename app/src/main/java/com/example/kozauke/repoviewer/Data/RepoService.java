package com.example.kozauke.repoviewer.Data;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoService {


    public void requestGoogleRepos(Callback<List<RepoListItem>> callback) {
        Gson gson = new GsonBuilder()
                //.setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<List<RepoListItem>> repositoriesCall = gitHubService.getProjectList(GitHubService.USER);
        repositoriesCall.enqueue(callback);
    }

    public void requestGoogleRepoDetails(Callback<RepoDetails> callback) {
        Gson gson = new GsonBuilder()
                //.setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GitHubService gitHubService = retrofit.create(GitHubService.class);
        Call<RepoDetails> repositoriesCall = gitHubService.getProjectDetails(GitHubService.USER, GitHubService.DEMO_REPO_NAME);
        repositoriesCall.enqueue(callback);
    }
}
