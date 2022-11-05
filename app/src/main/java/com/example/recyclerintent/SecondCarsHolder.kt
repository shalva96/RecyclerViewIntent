package com.example.recyclerintent

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SecondCarsHolder(item: View): RecyclerView.ViewHolder(item){


        private var secondAdapter: CarsAdapter = CarsAdapter()
        var myText: TextView = itemView.findViewById(R.id.tvTitle)
        var img: ImageView = itemView.findViewById(R.id.img)
        var recyclerItem: View = itemView.findViewById(R.id.itemHolder)

        fun setData(item: CarsData) {
            myText.text = item.title
            Picasso.get().load(item.image).into(img)


            recyclerItem.setOnClickListener {
                secondAdapter.listener?.itemClicked(item)
            }
        }


}