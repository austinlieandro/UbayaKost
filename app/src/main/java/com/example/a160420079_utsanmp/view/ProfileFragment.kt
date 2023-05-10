package com.example.a160420079_utsanmp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
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
import com.example.a160420079_utsanmp.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = 1
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        profileViewModel.fetch(id)

        ObserveViewModel()
    }

    private fun ObserveViewModel() {
        profileViewModel.profileLD.observe(viewLifecycleOwner, Observer {
            val txtUsernameProfile = view?.findViewById<TextView>(R.id.txtUsernameProfile)
            val imgProfile = view?.findViewById<ImageView>(R.id.imgProfile)
            val btnRiwayatTransaksi = view?.findViewById<Button>(R.id.btnRiwayatTransaksi)

            txtUsernameProfile?.text = "username : " + it.username
            imgProfile?.loadImage(it.imgUrl)

            btnRiwayatTransaksi?.setOnClickListener {
                val action = ProfileFragmentDirections.actionRiwayatTransaksiFromProfile(id = it.id)
                Navigation.findNavController(it).navigate(action)
            }
        })
    }
}
