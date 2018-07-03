package com.example.kozauke.repoviewer.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.kozauke.repoviewer.Data.RepoDetails;
import com.example.kozauke.repoviewer.Data.RepoListItem;
import com.example.kozauke.repoviewer.Data.RepoService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepoViewModel extends ViewModel {
    private RepoService service = new RepoService();
    private List<RepoListItem> repositories;
    private MutableLiveData<RepoDetails> chosenRepository = new MutableLiveData<>();


    public void init(){

    }

    public void onRepoSelected(){

    }

    //TODO: Apply RxJava Converter for google repos and gsonconv for repo details just for sake of showing off the RxJava in action.
    // Feels kinda pointless since these things don't really change but well

    public void requestRepoDetails(){
        Log.d("APP678", "Requesting repo details...");
        service.requestGoogleRepoDetails(getRepoDetailCallback());
    }

    // todo: private?
    public Callback<List<RepoListItem>> getRepoListCallback() {
        return new Callback<List<RepoListItem>>() {

            /**
             * Invoked for a received HTTP response.
             * <p>
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call {@link Response#isSuccessful()} to determine if the response indicates success.
             *
             * @param call
             * @param response
             */

            @Override
            public void onResponse(Call<List<RepoListItem>> call, Response<List<RepoListItem>> response) {
                //TODO: else? Some kind of data validation?
                if (response.isSuccessful()) {
                    Log.d("APP654", "A degree of success!");
                    Log.d("APP654", response.body().get(0).name + " " + response.body().get(1).name);
                }
                repositories=response.body();

            }
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             *
             * @param call
             * @param t - error
             */

            @Override
            public void onFailure(Call<List<RepoListItem>> call, Throwable t) {
                Log.d("APP", "SHIT: " + t);
            }
        };
    }

    //TODO: fill
    private Callback<RepoDetails> getRepoDetailCallback() {
        return new Callback<RepoDetails>() {
            @Override
            public void onResponse(Call<RepoDetails> call, Response<RepoDetails> response) {
                Log.d("APP678", "And we've got details!");
                Log.d("APP678", "response: \n" + response.body().toString());
                chosenRepository.setValue(response.body());

            }

            @Override
            public void onFailure(Call<RepoDetails> call, Throwable t) {
                Log.d("APP678", "Something failed...");
            }
        };
    }

    public MutableLiveData<RepoDetails> getChosenRepository() {
        return chosenRepository;
    }
}
