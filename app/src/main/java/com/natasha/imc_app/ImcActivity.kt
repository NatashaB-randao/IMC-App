package com.natasha.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class ImcActivity : AppCompatActivity() {

    private lateinit var editTextPeso: EditText
    private lateinit var editTextAltura: EditText
    private lateinit var buttonCalcular: Button
    private lateinit var textInputLayoutPeso: TextInputLayout
    private lateinit var textInputLayoutAltura: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        editTextPeso = findViewById(R.id.edit_text_peso)
        editTextAltura = findViewById(R.id.edit_text_altura)
        buttonCalcular = findViewById(R.id.button_calcular)

        textInputLayoutPeso = findViewById(R.id.text_input_layout_peso)
        textInputLayoutAltura = findViewById(R.id.text_input_layout_altura)

        val spinnerSexo = findViewById<Spinner>(R.id.spiner_sexo)

        // *** Lista que será carregada no spinner
        val options = arrayOf("Feminino", "Masculino", "Não informar")

        // *** Configurar o spinner
        spinnerSexo.adapter = ArrayAdapter<String>(this, R.layout.spinner_item, options)

        // *** Testar se o formulário está preenchido corretamente
        buttonCalcular.setOnClickListener{
            validaform()
        }

    }

    private fun validaform () : Boolean {

        var error = false

        if (editTextPeso.text.isEmpty()) {
          textInputLayoutPeso.error = "Digite seu peso!"
            error = true
        }else {
            textInputLayoutPeso.error = ""
        }

        if (editTextAltura.text.isEmpty()) {
            textInputLayoutAltura.error = "Digite a sua altura!"
            error = true
        }else {
            textInputLayoutAltura.error = ""
        }



//        if (editTextPeso.text.isEmpty()) {
//            editTextPeso.error = "Digite seu peso!"
//            error = true
//        }
//
//        if (editTextAltura.text.isEmpty()) {
//            editTextAltura.error = "Digite sua altura!"
//            error = true
//        }

        return error

    }
}