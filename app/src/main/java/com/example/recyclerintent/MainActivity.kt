package com.example.recyclerintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerintent.databinding.ActivityMainBinding
import com.example.recyclerintent.databinding.CarsDetailsBinding

class MainActivity : AppCompatActivity(), CarsAdapter.ICarsDetailListener  {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CarsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }
//
    private fun init() {
        adapter = CarsAdapter()
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            val list = getItems()
            adapter.addItem(list)
            adapter.setCarsDetailListener(this@MainActivity)
        }
    }




    private fun getItems(): ArrayList<CarsData> {
        val carsArrayList = ArrayList<CarsData>()
        carsArrayList.add(CarsData(
            "https://imageio.forbes.com/specials-images/" +
                    "imageserve/5f962df3991e5636a2f68758/0x0.jpg?format=jpg&crop=812,457,x89,y103,safe&width=1200",
            "Bugati",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"))
        carsArrayList.add(CarsData(
            "https://i.ytimg.com/vi/tArC9-RHmU4/maxresdefault.jpg",
            "Mercedes",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"))
        carsArrayList.add(CarsData(
            "https://mclaren.scene7.com/is/image/mclaren/DSC00052_6:crop-1x1?wid=1200&hei=1200",
            "McLaren",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"))
        carsArrayList.add(CarsData(
            "https://ichef.bbci.co.uk/news/976/cpsprodpb/BE5A/production/_123303784_gettyimages-524191066.jpg",
            "Porshe",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"))
        carsArrayList.add(CarsData(
                "https://imageio.forbes.com/specials-images/imageserve/62f2baa536726a900960c8bc/" +
                        "The-Acura-NSX-supercar-never-became-a-super-seller--and-is-being-dropped-from-the/" +
                        "0x0.jpg?format=jpg&crop=2025,1139,x290,y190,safe&width=960",
                "Xui ego znaet",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"))
        carsArrayList.addAll(carsArrayList)
        carsArrayList.addAll(carsArrayList)
        return carsArrayList
    }

    override fun itemClicked(item: CarsData) {
        val intent = Intent(this, CarsDetailActivity::class.java)
        intent.putExtra("KAY", item)
        startActivity(intent)
    }


}