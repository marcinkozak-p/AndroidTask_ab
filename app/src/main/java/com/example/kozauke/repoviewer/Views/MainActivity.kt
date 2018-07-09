package com.example.kozauke.repoviewer.Views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kozauke.repoviewer.Data.RepoDetails
import com.example.kozauke.repoviewer.R
import com.example.kozauke.repoviewer.ViewModel.RepoViewModel

class MainActivity : AppCompatActivity() {
    private val repoDetailsFragment = RepoDetailFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDataBinding()
    }

    private fun initDataBinding() {

    }

    fun onRepositorySelected(view: View) {
        showLoading()
        view.visibility = View.INVISIBLE

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
        //TODO: Put serializable bundle in here

        Log.d("APP678", "I'm putting the repo details to bundle. Repo: " + chosenRepo.toString())
        val bundle = Bundle()
        bundle.putParcelable("CHOSEN_REPO",chosenRepo)
        //TODO : we can add it post factum to bundle to support turning device
        // But this fragment is shown before we get repo thus our arguments are not set and we get NPE.
        // Maybe because I reinstituted bundle to newInstance thing it won't give us NPE but for now the fragment
        // Will be shown without repo for sure.
        repoDetailsFragment.arguments = bundle
        // TODO - fragment isn't being shown god damnit.
        Log.d("APP678", "The arguments are set. We're checking now if fragment is added and its visibility")
        if (!repoDetailsFragment.isAdded) {
            //TODO: ADDING SHOWS THE FRAGMENT TOO
            Log.d("APP678", "Fragment wasn't added. I'm adding it.")
            supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, repoDetailsFragment).commit()
        }

        if (!repoDetailsFragment.isVisible) {
            Log.d("APP678", "Fragment was invisible. Should be now...")
            supportFragmentManager.beginTransaction().show(repoDetailsFragment).commit()

        }
        else{
        Log.d("APP678", "The fragment was visible")
        }
    }

    private fun hideLoading() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showLoading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}