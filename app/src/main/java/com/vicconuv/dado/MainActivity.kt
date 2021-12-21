package com.vicconuv.dado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * Actividad principal de la app de dado
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //en android los id tienen la estructura R.<type>.<name>
        //en el caso de un boton, el id tiene un id de recurso y la etiqueta tiene otro
        //Se pasa la referencia del boton
        val rollButton: Button = findViewById(R.id.button)

        //event handler mediante una lambda

        rollButton.setOnClickListener {
            //codigo de la implementacion
            //crea una notificacion tipo toast y la muestra
            val toast = Toast.makeText(this, "El dado ha sido lanzado", Toast.LENGTH_SHORT)
            toast.show();

            //girar dado
            rollDice()
        }
        //gira el dado justo despues de iniciar la actividad
        rollDice()
    }

    /**
     * gira el dado y actualiza el textView
     */
    private fun rollDice() {
        val myDice = Dice(6)
        //gira el dado
        val sideRolled = myDice.roll()
        /**
         * codigo que actualiza textView, se cambia por ImageView
         * //instancia a textView y le asigna un numero
         * val resultDice: TextView = findViewById(R.id.textView)
         * resultDice.text = myDice.roll().toString()
        * */

        //busca la imagen del dado en el layout
        val imgDice: ImageView = findViewById(R.id.imageView)

        //devuelve la referencia del drawable correspondiente de acuerdo al numero obtenido
        var resourceName = when(sideRolled){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //aplica la imagen correcta al source del imageView
        imgDice.setImageResource(resourceName);

        //agrega descripcion al imageView
        imgDice.contentDescription = sideRolled.toString();
    }
}

/**
 * Clase que brinda la funcionalidad de un dado
 */

class Dice(val numSides: Int) {

    //tipo de dato IntRange
    private val diceRange = 1..numSides
    fun roll(): Int {
        return diceRange.random()
    }
}