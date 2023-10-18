package com.example.myapplication.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.NumberPicker
import android.widget.Toast
import com.example.myapplication.R

class ResultActivity : AppCompatActivity() {

    private var selectedButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val buttonMan = findViewById<Button>(R.id.buttonMan)
        val buttonWoman = findViewById<Button>(R.id.buttonWoman)

        buttonMan.setOnClickListener {
            handleButtonClick(buttonMan)
        }

        buttonWoman.setOnClickListener {
            handleButtonClick(buttonWoman)
        }

        val numberPicker = findViewById<NumberPicker>(R.id.numberPicker)
        val numberPicker1 = findViewById<NumberPicker>(R.id.numberPicker1)
        val numberPicker2 = findViewById<NumberPicker>(R.id.numberPicker2)

        // Configurar el rango de valores para el NumberPicker
        numberPicker.minValue = 20
        numberPicker.maxValue = 250
        numberPicker.value = 60

        // Configurar el rango de valores para el NumberPicker1
        numberPicker1.minValue = 0
        numberPicker1.maxValue = 9
        numberPicker1.value = 0

        // Configurar el rango de valores para el NumberPicker2
        numberPicker2.minValue = 100
        numberPicker2.maxValue = 210
        numberPicker2.value = 170

        val calcularButton = findViewById<Button>(R.id.calcularButton)

        calcularButton.setOnClickListener {
            onCalcularButtonClick(it)
        }
    }

    private fun handleButtonClick(clickedButton: Button) {
        selectedButton?.setBackgroundResource(getNormalDrawableId(selectedButton?.id))
        clickedButton.setBackgroundResource(getCheckedDrawableId(clickedButton.id))
        selectedButton = clickedButton
    }

    private fun getNormalDrawableId(buttonId: Int?): Int {
        return when (buttonId) {
            R.id.buttonMan -> R.drawable.man
            R.id.buttonWoman -> R.drawable.woman
            else -> 0
        }
    }

    private fun getCheckedDrawableId(buttonId: Int?): Int {
        return when (buttonId) {
            R.id.buttonMan -> R.drawable.man_cheked
            R.id.buttonWoman -> R.drawable.woman_cheked
            else -> 0
        }
    }

    fun onButtonClick(view: View) {
        // Este método se llama cuando se hace clic en los botones (puedes dejarlo vacío si no necesitas hacer nada aquí)
    }

    fun onCalcularButtonClick(view: View) {
        // Verificar si selectedButton no es nulo antes de usarlo
        val selectedButtonId = selectedButton?.id

        if (selectedButtonId != null) {
            // Obtener los valores de los NumberPicker y el botón seleccionado
            val valueFromNumberPicker = findViewById<NumberPicker>(R.id.numberPicker).value
            val valueFromNumberPicker1 = findViewById<NumberPicker>(R.id.numberPicker1).value
            val valueFromNumberPicker2 = findViewById<NumberPicker>(R.id.numberPicker2).value

            val genero = selectedButtonId
            val pesoEnt = valueFromNumberPicker.toInt()
            val pesoDec = valueFromNumberPicker1.toInt()
            val estaturaCent = valueFromNumberPicker2.toInt()

            // Convertir las partes a un número decimal
            val pesoTotal: Double = "$pesoEnt.$pesoDec".toDouble()

            // Convertir cm a m
            val estaturaMet = estaturaCent/100.0

            // Calcular IMC y redondearlo a 2 decimales
            val imc = String.format("%.2f", pesoTotal / (estaturaMet * estaturaMet)).toDouble()

            // Calcular Peso Sugerido
            val pesoSugerido = String.format("%.1f", ((18.5 + 24.9)/2) * (estaturaMet * estaturaMet)).toDouble()

            // Pasar los valores a la siguiente actividad
            Log.i("Genero","Se dio click... $genero")
            Log.i("Peso","Se unio los datos... $pesoTotal")
            Log.i("Estatura","Convirtio a metros... $estaturaMet")
            Log.i("IMC","Se calculó... $imc")
            Log.i("Peso_Sugerido","Se calculo... $pesoSugerido")
            val intent = Intent(this, CalcActivity::class.java)
            intent.putExtra("VALUE_PESO", pesoTotal)
            intent.putExtra("VALUE_ESTATURA", estaturaMet)
            intent.putExtra("VALUE_IMC", imc)
            intent.putExtra("VALUE_PESO_SUGERIDO", pesoSugerido)
            intent.putExtra("SELECTED_BUTTON_ID", selectedButtonId)
            startActivity(intent)
        } else {
            // Mostrar mensaje emergente
            Toast.makeText(this, "Por favor, selecciona el género", Toast.LENGTH_SHORT).show()
            Log.e("ResultActivity", "selectedButton es nulo")
        }
    }
}