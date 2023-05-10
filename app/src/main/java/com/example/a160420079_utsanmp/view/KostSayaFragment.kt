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
import com.example.a160420079_utsanmp.viewmodel.KostSayaViewModel
import com.example.a160420079_utsanmp.viewmodel.KostViewModel

class KostSayaFragment : Fragment() {
    private val kostSayaListAdapter = KostSayaListAdapter(arrayListOf())
    private lateinit var kostSayaViewModel: KostSayaViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var recView = view?.findViewById<RecyclerView>(R.id.recViewKostSaya)
        kostSayaViewModel = ViewModelProvider(this).get(KostSayaViewModel::class.java)
        kostSayaViewModel.fetch()

        recView?.let {
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = kostSayaListAdapter
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kost_saya, container, false)
    }

    private fun observe(){
        kostSayaViewModel.kostSayaLD.observe(viewLifecycleOwner, Observer {
            kostSayaListAdapter.updateKostSaya(it)
        })
    }
}