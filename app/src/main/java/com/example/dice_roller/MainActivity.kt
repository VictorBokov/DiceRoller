package com.example.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var oneCount = 1
    var twoCount = 1
    var threeCount = 1
    var fourCount = 1
    var fiveCount = 1
    var sixCount = 1


    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {

        val random = Random.nextInt(6) + 1

        val drawableResourse = when {
            random == 1 -> R.drawable.dice_1
            random == 2 -> R.drawable.dice_2
            random == 3 -> R.drawable.dice_3
            random == 4 -> R.drawable.dice_4
            random == 5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        val textViewsCount = when {
            random == 1 -> text_view1.setText((oneCount++).toString())
            random == 2 -> text_view2.setText((twoCount++).toString())
            random == 3 -> text_view3.setText((threeCount++).toString())
            random == 4 -> text_view4.setText((fourCount++).toString())
            random == 5 -> text_view5.setText((fiveCount++).toString())
            else -> text_view6.setText((sixCount++).toString())
        }

        diceImage.setImageResource(drawableResourse)
    }
}