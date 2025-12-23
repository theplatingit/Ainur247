package ru.zelmex.myapp2312

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {

    lateinit var textViewResults: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        textViewResults = findViewById(R.id.textViewResults)

        val result1 = intent.getStringExtra("result1") ?: ""
        val result2 = intent.getStringExtra("result2") ?: ""
        val result3 = intent.getStringExtra("result3") ?: ""

        val text = """
            РЕЗУЛЬТАТЫ ВСЕХ ЗАДАНИЙ
            
            ЗАДАНИЕ 1
            Сумма, разность, произведение и частное квадратов двух чисел
            
            $result1
            
            ЗАДАНИЕ 2
            Поменять местами значения переменных A и B
            
            $result2
            
            ЗАДАНИЕ 3
            Перевод градусов Фаренгейта в градусы Цельсия
            
            $result3
        """.trimIndent()

        textViewResults.text = text
    }
}