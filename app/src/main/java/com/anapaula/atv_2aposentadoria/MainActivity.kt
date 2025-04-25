package com.anapaula.atv_2aposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.anapaula.atv_2aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        val items = listOf("Feminino" , "Masculino")

        //
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

        //Confuguração do layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Que
        binding.genero.adapter = adapter

        binding.botao.setOnClickListener {

            val sexo = binding.genero.selectedItem as String

            val idade = binding.idade.text.toString().toLongOrNull()

            val resultado: Long
            if (idade != null) {

                if(sexo=="Feminino") {
                    resultado = 62 - idade
                } else{
                    resultado = 65 - idade
                }
                binding.frase.text=if (resultado>0) {
                    "Faltam $resultado anos para você se aposentar."

                } else {
                    "Você já pode se aposentar."
                }

            }else{

                binding.frase.text="Digite sua idade"


            }


        }
    }
}