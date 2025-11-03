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
    val rATIO = 0.9
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        // setContentView(R.layout.activity_main)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //    insets
        //}
        //activity_main.xml -> ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.convertir.setOnClickListener (this)
    }

    override fun onClick(view: View) {
        if (view === binding.convertir) {
            try {
                if (binding.EurosADolares.isChecked) {
                    binding.dolares.setText(
                        Conversion.convertirADolares(binding.euros.text.toString(), rATIO)
                    )
                } else {
                    binding.euros.setText(
                        Conversion.convertirAEuros(binding.dolares.text.toString(), rATIO)
                    )
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Error en la conversión: " + e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}