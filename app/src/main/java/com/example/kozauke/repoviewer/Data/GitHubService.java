package com.example.kozauke.repoviewer.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    String HTTPS_API_GITHUB_URL = "https://api.github.com/";
    String USER = "marcinkozak-p";
    //todo: fill dood
    String DEMO_REPO_NAME="AndroidTask_ab";

    //TODO: Zaimplementować to odpowiednio żeby były docelowe guglowe a nie moje repki
    String GOOGLE_GITHUB_REPOS = "https://api.github.com/users/google/repos";

    @GET("users/{user}/repos")
    Call<List<RepoListItem>> getProjectList(@Path("user") String user);

    //TODO: Zwróć uwagę, że tutaj ścieżka jest inna: repos/user/reponame, a nie jak wyżej {user}/repos. {user}/repos/{reponame} nie zadziała!
    @GET("/repos/{user}/{reponame}")
    Call<RepoDetails> getProjectDetails(@Path("user") String user, @Path("reponame") String projectName);
}
