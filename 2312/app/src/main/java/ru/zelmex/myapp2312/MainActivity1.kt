package ru.zelmex.myapp2312

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity1 : AppCompatActivity() {

    lateinit var editTextNum1: EditText
    lateinit var editTextNum2: EditText
    lateinit var textViewResult: TextView
    lateinit var btnCalculate: Button
    lateinit var btnNext: Button

    var result1 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        editTextNum1 = findViewById(R.id.editTextNum1)
        editTextNum2 = findViewById(R.id.editTextNum2)
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
                val intent = Intent(this@MainActivity1, MainActivity2::class.java)
                intent.putExtra("result1", result1)
                startActivity(intent)
            }
        })
    }

    fun calculateResult() {
        try {
            val num1 = editTextNum1.text.toString().toDouble()
            val num2 = editTextNum2.text.toString().toDouble()

            if (num1 == 0.0 || num2 == 0.0) {
                Toast.makeText(this, "Числа не должны быть нулевыми!", Toast.LENGTH_SHORT).show()
                return
            }

            val square1 = num1 * num1
            val square2 = num2 * num2

            val sum = square1 + square2
            val difference = square1 - square2
            val product = square1 * square2
            val quotient = square1 / square2

            result1 = "Сумма квадратов: ${String.format("%.2f", sum)}\n" +
                    "Разность квадратов: ${String.format("%.2f", difference)}\n" +
                    "Произведение квадратов: ${String.format("%.2f", product)}\n" +
                    "Частное квадратов: ${String.format("%.2f", quotient)}"

            textViewResult.text = result1
        } catch (e: Exception) {
            Toast.makeText(this, "Введите корректные числа!", Toast.LENGTH_SHORT).show()
        }
    }
}