package ru.zelmex.myapp2312

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {

    lateinit var editTextFahrenheit: EditText
    lateinit var textViewResult: TextView
    lateinit var btnCalculate: Button
    lateinit var btnNext: Button

    var result3 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val result1 = intent.getStringExtra("result1") ?: ""
        val result2 = intent.getStringExtra("result2") ?: ""

        editTextFahrenheit = findViewById(R.id.editTextFahrenheit)
        textViewResult = findViewById(R.id.textViewResult)
        btnCalculate = findViewById(R.id.btnCalculate)
        btnNext = findViewById(R.id.btnNext)

        btnCalculate.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                calculateResult()
            }
        })

        btnNext.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this@MainActivity3, MainActivity4::class.java)
                intent.putExtra("result1", result1)
                intent.putExtra("result2", result2)
                intent.putExtra("result3", result3)
                startActivity(intent)
            }
        })
    }

    fun calculateResult() {
        try {
            val fahrenheit = editTextFahrenheit.text.toString().toDouble()

            val celsius = (fahrenheit - 32) * 5 / 9

            result3 = "Температура в градусах Цельсия: ${String.format("%.2f", celsius)}°C"
            textViewResult.text = result3
        } catch (e: Exception) {
            Toast.makeText(this, "Введите корректную температуру!", Toast.LENGTH_SHORT).show()
        }
    }
}