package com.example.myapplication.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication.R

class CalcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        val tvIMC = findViewById<TextView>(R.id.tvIMC)
        val tvGenero = findViewById<TextView>(R.id.tvGenero)
        val tvPeso = findViewById<TextView>(R.id.tvPeso)
        val tvEstatura = findViewById<TextView>(R.id.tvEstatura)
        val imRange = findViewById<ImageView>(R.id.imRange)
        val tvTitleConsejo = findViewById<TextView>(R.id.tvTitleConsejo)
        val tvBodyConsejo = findViewById<TextView>(R.id.tvBodyConsejo)
        val tvPesoSugerido = findViewById<TextView>(R.id.tvPesoSugerido)

        val imc = intent.getDoubleExtra("VALUE_IMC",0.0)
        val peso = intent.getDoubleExtra("VALUE_PESO",0.0)
        val estatura = intent.getDoubleExtra("VALUE_ESTATURA",0.0)
        val genero = intent.getIntExtra("SELECTED_BUTTON_ID",0)
        val pesoSugerido= intent.getDoubleExtra("VALUE_PESO_SUGERIDO",0.0)

        val gender: String = when (genero) {
            R.id.buttonMan -> "Hombre"
            R.id.buttonWoman -> "Mujer"
            else -> "Desconocido"
        }

        when {
            imc < 15.9 -> imRange.setImageResource(R.drawable.delgadez_extrema)
            imc <= 16.9 -> imRange.setImageResource(R.drawable.delgadez_severa)
            imc <= 18.4 -> imRange.setImageResource(R.drawable.bajo_peso)
            imc <= 24.9 -> imRange.setImageResource(R.drawable.normal)
            imc <= 29.9 -> imRange.setImageResource(R.drawable.sobrepeso)
            imc <= 34.9 -> imRange.setImageResource(R.drawable.obesidad_moderada)
            imc <= 39.9 -> imRange.setImageResource(R.drawable.obesidad_severa)
            else -> imRange.setImageResource(R.drawable.obesidad_morbida)
        }

        when {
            imc < 15.9 -> tvTitleConsejo.text = "¡Mantente Alerta!"
            imc <= 16.9 -> tvTitleConsejo.text = "¡Cuidado!"
            imc <= 18.4 -> tvTitleConsejo.text = "¡Casi en el punto!"
            imc <= 24.9 -> tvTitleConsejo.text = "¡Excelente!"
            imc <= 29.9 -> tvTitleConsejo.text = "¡Ni mucho ni poco!"
            imc <= 34.9 -> tvTitleConsejo.text = "¡No esperes más!"
            imc <= 39.9 -> tvTitleConsejo.text = "¡Hora de cambiar!"
            else -> tvTitleConsejo.text = "¡Apresurate al cambio!"
        }

        when {
            imc < 15.9 -> tvBodyConsejo.text = "La nutrición adecuada es clave para tu bienestar. Consulta con un profesional de la salud para desarrollar un plan que te apoye en el camino hacia un peso saludable. Recuerda que tu salud es lo más importante y mereces cuidarte de manera integral."
            imc <= 16.9 -> tvBodyConsejo.text = "Tu cuerpo necesita nutrición adecuada para funcionar de manera óptima. Busca la orientación de un profesional de la salud para desarrollar un plan que te ayude a aumentar gradualmente tu peso de manera saludable."
            imc <= 18.4 -> tvBodyConsejo.text = "Deberías plantearte formas de ganar peso de manera saludable. Busca asesoramiento de un profesional de la salud o nutricionista para desarrollar planes que te ayuden a alcanzar tu peso ideal de manera segura."
            imc <= 24.9 -> tvBodyConsejo.text = "Estás en un punto maravilloso. Mantén esos hábitos saludables, estás haciendo un trabajo increíble para cuidar de ti mismo. Tu dedicación al bienestar es admirable. ¡Sigue así!"
            imc <= 29.9 -> tvBodyConsejo.text = "Deberías incorporar opciones más saludables en tu dieta y practicar actividad física de manera regular. El objetivo no es solo perder peso, sino adoptar un estilo de vida más saludable y sostenible."
            imc <= 34.9 -> tvBodyConsejo.text = "La acción es la clave en tu viaje hacia un peso más saludable. Implementa cambios positivos en tu estilo de vida. Ajusta tu dieta y aumenta gradualmente la actividad física."
            imc <= 39.9 -> tvBodyConsejo.text = "Es hora de comprometerte con una transformación positiva. Consulta con profesionales de la salud para crear un plan personalizado que aborde tu situación."
            else -> tvBodyConsejo.text = "La urgencia es real, pero también lo es tu capacidad de transformación. Apresúrate al cambio con determinación y compromiso. Busca el apoyo integral de profesionales de la salud para diseñar un plan seguro y efectivo."
        }

        tvIMC.text = "$imc"
        tvPesoSugerido.text = "Peso sugerido: $pesoSugerido Kg"
        tvGenero.text = "Tu Género: $gender"
        tvPeso.text = "Tu Peso: $peso Kg"
        tvEstatura.text = "Tu Estatura: $estatura m"

    }
}