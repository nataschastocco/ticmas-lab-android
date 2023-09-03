package com.curso.android.app.practica.comparison.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.curso.android.app.practica.comparison.R


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val compareButton = findViewById<Button>(R.id.compareButton)
        compareButton.setOnClickListener {
            val editText1 = findViewById<EditText>(R.id.editText1)
            val editText2 = findViewById<EditText>(R.id.editText2)

            val text1 = editText1.text.toString()
            val text2 = editText2.text.toString()

            viewModel.setText1(text1)
            viewModel.setText2(text2)

            viewModel.compareTexts()
        }
        viewModel.result.observe(this, Observer { newResult ->
            val resultTextView = findViewById<TextView>(R.id.resultTextView)
            resultTextView.text = newResult
        })
    }
}


