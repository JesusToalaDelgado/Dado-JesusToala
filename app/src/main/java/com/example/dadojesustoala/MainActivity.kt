package com.example.dadojesustoala

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * Permite ver al usuario el dado con su respectivo resultado
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }
    /**
     * Tira los dados y muestra los resultados a la pantalla
     */
    private fun rollDice() {
        // Crea un nuevo objeto Dice con 6 lados y tira los dados
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Encuentra la ImageView en el diseño
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Actualiza ImageView con el ID de recurso dibujable correcto
            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}