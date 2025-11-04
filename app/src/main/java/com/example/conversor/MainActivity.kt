package com.example.conversor

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.conversor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const private val RATIO = 0.87
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
        //activity_main.xml -> ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.convertir.setOnClickListener (this)
    }

    override fun onClick(view: View) {
        lateinit var valor: String

        if (view === binding.convertir) {
            try {
                if (binding.EurosADolares.isChecked) {
                    valor = binding.euros.text.toString()
                    if (!valor.isEmpty())
                        binding.dolares.setText(Conversion.convertirADolares(valor, RATIO))
                    else
                        mostrarMensaje("Introduce un valor en los Euros")
                } else {
                    valor = binding.dolares.text.toString()
                    if (!valor.isEmpty())
                        binding.euros.setText(Conversion.convertirAEuros(valor, RATIO))
                    else
                        mostrarMensaje("Introduce un valor en los Dólares")
                }
            } catch (e: NumberFormatException) {
                mostrarMensaje("Error en la conversión: " + e.message)
            }
        }
    }

    private fun mostrarMensaje(texto: String) {
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
    }
}