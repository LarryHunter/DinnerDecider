package com.hunterdev.dinnerdecider

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf("Mexican", "Pizza", "Burgers", "Italian", "Chinese", "Thai", "BBQ", "Hot Wings")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selectedFoodText.text = foodList[randomFood]
        }

        addFoodBtn.setOnClickListener {
            val newFood = addFoodText.text.toString()
            if (newFood.isEmpty()) {
                Toast.makeText(this, "Please enter a food item...", Toast.LENGTH_SHORT).show()
            } else {
                foodList.add(newFood)
                Toast.makeText(this, newFood + " successfully added...", Toast.LENGTH_LONG).show()
                addFoodText.text.clear()
            }
        }
    }
}
