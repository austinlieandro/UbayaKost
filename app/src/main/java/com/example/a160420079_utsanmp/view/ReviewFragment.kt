package com.example.a160420079_utsanmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420079_utsanmp.R
import com.example.a160420079_utsanmp.viewmodel.KostDetailViewModel
import com.example.a160420079_utsanmp.viewmodel.KostSayaViewModel
import com.example.a160420079_utsanmp.viewmodel.ReviewViewModel

class ReviewFragment : Fragment() {
    private lateinit var reviewViewModel: ReviewViewModel
    private val reviewListadapter = ReviewAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            var recView = view?.findViewById<RecyclerView>(R.id.recViewReview)
            val id = ReviewFragmentArgs.fromBundle(requireArguments()).kostid

            reviewViewModel = ViewModelProvider(this).get(ReviewViewModel::class.java)
            reviewViewModel.fetch(id)

            recView?.let {
                it.layoutManager = LinearLayoutManager(context)
                it.adapter = reviewListadapter
            }

            observe()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    private fun observe(){
        reviewViewModel.reviewLD.observe(viewLifecycleOwner, Observer {
            reviewListadapter.updateReview(it)
        })
    }

}