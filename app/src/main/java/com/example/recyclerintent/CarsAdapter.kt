package com.example.recyclerintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class CarsAdapter : RecyclerView.Adapter<CarsAdapter.CarsHolder>() {

    private val carsList = ArrayList<CarsData>()

    inner class CarsHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var myText: TextView = itemView.findViewById(R.id.tvTitle)
        var img: ImageView = itemView.findViewById(R.id.img)
        private var recyclerItem: View = itemView.findViewById(R.id.itemHolder)

        fun setData(item: CarsData) {
            myText.text = item.title
            Picasso.get().load(item.image).into(img)

            recyclerItem.setOnClickListener {
                listener?.itemClicked(item)
            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_holder, parent, false)
        return CarsHolder(view)
    }

    override fun onBindViewHolder(holder: CarsHolder, position: Int) {
        val currentItem = carsList[position]
        holder.setData(currentItem)

//        holder.recyclerItem.setOnClickListener {
//            listener?.itemClicked(currentItem)
//        }
    }

    override fun getItemCount(): Int {
        return carsList.size
    }


    fun addItem(item: ArrayList<CarsData>) {
        this.carsList.clear()
        this.carsList.addAll(item)
        notifyDataSetChanged()
    }


    fun setCarsDetailListener(itemClickListener: ICarsDetailListener) {
        this.listener = itemClickListener
    }


    var listener: ICarsDetailListener? = null

    interface ICarsDetailListener {
        fun itemClicked(item: CarsData)
    }


}