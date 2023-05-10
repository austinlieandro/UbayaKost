package com.example.a160420079_utsanmp.view

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160420079_utsanmp.R
import com.example.a160420079_utsanmp.util.loadImage
import com.example.a160420079_utsanmp.viewmodel.KostDetailViewModel
import com.example.a160420079_utsanmp.viewmodel.KostViewModel

class KostDetailFragment : Fragment() {
    private lateinit var kostDetailViewModel: KostDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kost_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val id = KostDetailFragmentArgs.fromBundle(requireArguments()).kostDetail

            kostDetailViewModel = ViewModelProvider(this).get(KostDetailViewModel::class.java)
            kostDetailViewModel.fetch(id)

            ObserveViewModel()
        }
    }

    private fun ObserveViewModel(){
        kostDetailViewModel.kostLD.observe(viewLifecycleOwner, Observer { kostLD->
            val txtNamaKostDetail = view?.findViewById<TextView>(R.id.txtNamaKostDetail)
            val txtLocationDetail = view?.findViewById<TextView>(R.id.txtLocationDetail)
            val txtContentDescDetail = view?.findViewById<TextView>(R.id.txtContentDescDetail)
            val txtPriceDetail = view?.findViewById<TextView>(R.id.txtPriceDetail)
            val imgKostDetail = view?.findViewById<ImageView>(R.id.imgKostDetail)
            val btnReview = view?.findViewById<Button>(R.id.btnReview)
            val btnBookDetail = view?.findViewById<Button>(R.id.btnBookDetail)

                txtNamaKostDetail?.text = kostLD.nameKost
                txtLocationDetail?.text = kostLD.alamat
                txtContentDescDetail?.text = kostLD.description
                txtPriceDetail?.text = "Rp " + kostLD.price.toString()
                imgKostDetail?.loadImage(kostLD.imgUrl)


            btnReview?.setOnClickListener {
                val acion = KostDetailFragmentDirections.actionReviewFromDetail(kostid = kostLD.id)
                Navigation.findNavController(it).navigate(acion)
            }

            btnBookDetail?.setOnClickListener {
                val action = KostDetailFragmentDirections.actionBookFromDetail()
                Navigation.findNavController(it).navigate(action)
            }
        })
    }
}