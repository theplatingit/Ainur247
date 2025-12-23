package ru.zelmex.myapp2312

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var editTextA: EditText
    lateinit var editTextB: EditText
    lateinit var textViewResult: TextView
    lateinit var btnCalculate: Button
    lateinit var btnNext: Button

    var result2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val result1 = intent.getStringExtra("result1") ?: ""

        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
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
                val intent = Intent(this@MainActivity2, MainActivity3::class.java)
                intent.putExtra("result1", result1)
                intent.putExtra("result2", result2)
                startActivity(intent)
            }
        })
    }

    fun calculateResult() {
        try {
            var a = editTextA.text.toString()
            var b = editTextB.text.toString()

            if (a.isEmpty() || b.isEmpty()) {
                Toast.makeText(this, "Введите значения A и B!", Toast.LENGTH_SHORT).show()
                return
            }

            val temp = a
            a = b
            b = temp

            result2 = "Новое значение A: $a\nНовое значение B: $b"
            textViewResult.text = result2
        } catch (e: Exception) {
            Toast.makeText(this, "Ошибка ввода!", Toast.LENGTH_SHORT).show()
        }
    }
}