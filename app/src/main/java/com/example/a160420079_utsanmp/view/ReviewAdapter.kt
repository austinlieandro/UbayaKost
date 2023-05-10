package com.example.a160420079_utsanmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a160420079_utsanmp.R
import com.example.a160420079_utsanmp.model.Kost
import com.example.a160420079_utsanmp.model.Review
import com.example.a160420079_utsanmp.util.loadImage

class ReviewAdapter(private val riviewList: ArrayList<Review>): RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    class  ReviewViewHolder(var view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.review_layout_item, parent, false)
        return ReviewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return riviewList.size
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val txtUsernameReview = holder.view.findViewById<TextView>(R.id.txtUsernameReview)
        val txtTanggalReview = holder.view.findViewById<TextView>(R.id.txtTanggalReview)
        val txtReviewUser = holder.view.findViewById<TextView>(R.id.txtReviewUser)
        val imgProfileUserRiview = holder.view.findViewById<ImageView>(R.id.imgProfileUserRiview)

        txtUsernameReview.text = riviewList[position].username
        txtTanggalReview.text = riviewList[position].tanggal
        txtReviewUser.text = riviewList[position].review
        imgProfileUserRiview.loadImage(riviewList[position].imgUrl)
    }

    fun updateReview(newReviewList: ArrayList<Review>) {
        riviewList.clear()
        riviewList.addAll(newReviewList)
        notifyDataSetChanged()
    }
}