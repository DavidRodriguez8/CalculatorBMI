package com.example.myapplication.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.ButtonBarLayout
import com.example.myapplication.R
import kotlin.math.log

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnOK = findViewById<Button>(R.id.btnOK)
        /*val EditTextName = findViewById<AppCompatEditText>(R.id.EditTextName)*/

        btnOK.setOnClickListener {
            startActivity(
                Intent(
                    this@FirstAppActivity,
                    ResultActivity::class.java
                )
            )
        }
    }
}
/*
            val name = EditTextName.text.toString()
            if (name.isNotEmpty()) {
                Log.i("first","Se dio click... $name")
                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }
    }
}
*/