package com.example.kozauke.repoviewer.Views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kozauke.repoviewer.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RepoDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RepoDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class RepoDetailFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    //private var chosenRepo: RepoDetails? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //TODO Get chosen repo from activity
        //activity
        //chosenRepo = arguments!!.getParcelable("CHOSEN_REPO")

        // val binding: FragmentRepoDetailBinding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_repo_detail,container,false)
        //val repo = RepoDetails()
        //TODO: something's wrong here
        //binding.repo
        //return container//binding.root
        return inflater.inflate(R.layout.fragment_repo_detail, container, false)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //TODO: what about this?
        /* if (context is OnFragmentInteractionListener) {
             listener = context
         } else {
             throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
         }*/
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and mName
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(): RepoDetailFragment =
                RepoDetailFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
