package com.example.headfirstandroid_chapter2_beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val beerColor = findViewById<Spinner>(R.id.beer_color)
        val findBrand = findViewById<Button>(R.id.find_beer)
        val brands = findViewById<TextView>(R.id.brands)

        findBrand.setOnClickListener{
            val color = "${beerColor.selectedItem}"
            val beers = getBeers(color).reduce{str, item -> str + "\n" + item}
            brands.text = beers
        }
    }

    fun getBeers(color : String) : List<String>{
        return when(color){
            "Light" -> listOf("Jail Pale Ale", "Light Lite")
            "Amber" -> listOf("Jack Amber", "Red Moose")
            "Brown" -> listOf("Brown Bear Beer", "Bock Brownie")
            else    -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}