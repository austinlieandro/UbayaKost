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
import com.example.a160420079_utsanmp.viewmodel.KostViewModel

class HomeFragment : Fragment() {
    private val kostListAdapter = KostListAdapter(arrayListOf())
    private lateinit var kostViewModel: KostViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var recView = view?.findViewById<RecyclerView>(R.id.recyclerView)
        kostViewModel = ViewModelProvider(this).get(KostViewModel::class.java)
        kostViewModel.fetch()

        recView?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = kostListAdapter
        }

        observe()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun observe(){
        kostViewModel.kostLD.observe(viewLifecycleOwner, Observer {
            kostListAdapter.updateKost(it)
        })
    }

}