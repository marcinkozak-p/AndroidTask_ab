package com.example.kozauke.repoviewer.Views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kozauke.repoviewer.Data.RepoDetails
import com.example.kozauke.repoviewer.R
import com.example.kozauke.repoviewer.ViewModel.RepoViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDataBinding()
    }
    //TODO: Remove
    //val reposervice = RepoService()
    //val repoViewModel = RepoViewModel()
    //reposervice.requestGoogleRepos(repoViewModel.repoListCallback)

    private fun initDataBinding() {

    }

    private fun onRepositorySelected(){
        showLoading()

        val chosenRepoObserver = Observer<RepoDetails> {
            Log.d("APP678", "WELL SOMETHING HAS APPARENTLY HAPPENED")
            hideLoading()
            showRepoDetails(it)
        }

        val mRepoViewModel = ViewModelProvider(viewModelStore, ViewModelProvider.NewInstanceFactory()).get(RepoViewModel::class.java)
        mRepoViewModel.chosenRepository.observe(this, chosenRepoObserver)
        mRepoViewModel.requestRepoDetails()
    }

    private fun showRepoDetails(chosenRepo: RepoDetails?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}