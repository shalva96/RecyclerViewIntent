package com.example.recyclerintent

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerintent.databinding.CarsDetailsBinding
import com.squareup.picasso.Picasso

class CarsDetailActivity: AppCompatActivity() {

    lateinit var binding: CarsDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CarsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item: CarsData = intent.getSerializableExtra("KAY") as CarsData

        binding.apply {
            Picasso.get().load(item.image).into(imageDetailId)
            titleDetailId.text = item.title
            descriptionDetailId.text = item.description
        }


    }

}