package com.example.checkpoint_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)
        val calculateButton: Button = findViewById(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedRadioButton: RadioButton = findViewById(selectedRadioButtonId)
            val heightText = editTextHeight.text.toString()

            if (selectedRadioButtonId == -1) {
                showToast("Selecione o sexo.")
                return@setOnClickListener
            }

            if (heightText.isBlank()) {
                showToast("Digite a altura.")
                return@setOnClickListener
            }

            val height = heightText.toDouble()
            val weight = if (selectedRadioButton.text == "Masculino") {
                (72.7 * height) - 58
            } else {
                (62.1 * height) - 44.7
            }

            showToast("O peso ideal é: %.2f kg".format(weight))
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}