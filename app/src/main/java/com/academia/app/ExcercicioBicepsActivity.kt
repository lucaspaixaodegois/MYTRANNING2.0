package com.academia.app

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class ExcercicioBicepsActivity : AppCompatActivity() {


    var count: Int = 0
    lateinit var option: Spinner
    lateinit var result: TextView
    lateinit var repetir: TextView
    lateinit var nrepetir: TextView
    lateinit var btncont: Button
    lateinit var btncont2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercicio_biceps)



        option = findViewById(R.id.spinner1) as Spinner
        result = findViewById(R.id.txt1) as TextView
        repetir = findViewById(R.id.txt2) as TextView
        nrepetir = findViewById(R.id.txt3) as TextView
        btncont = findViewById(R.id.btncont) as Button
        btncont2 = findViewById(R.id.btncont2) as Button

        btncont.setBackgroundColor(Color.CYAN)
        btncont2.setBackgroundColor(Color.RED)

        var options = arrayOf("")
        var prencher: String = "Biceps" // Ao clicar
        fun verificaString(campo: String) {
            if (campo.equals("Abdominais") || campo.equals("ABDOMINAIS")) {

                options = arrayOf("Exercicios", "Supra", "Oblíquio", "Pernas Elevadas", "Prancha")
            }
            if (campo.equals("Antebraços") || campo.equals("ANTEBRAÇOS")) {

                options = arrayOf("Exercicios", "Rosca De Punho", "Suspensão na Barra", "Rosca de Punho Invertido")
            }
            if (campo.equals("Biceps") || campo.equals("BICEPS")) {

                options = arrayOf("Exercicios", "Rosca concentrada", "Barra fixa", "Rosca inclinada")
            }
            if (campo.equals("Costas") || campo.equals("COSTAS")) {

                options = arrayOf("Exercicios", "Barra fixa", "Remada curvada", "Agachamento frontal", "Prancha")
            }
            if (campo.equals("Peito") || campo.equals("PEITO")) {

                options = arrayOf("Exercicios", "Cross Over", "Crucifixo reto", "Flexões", "Peck-Deck")
            }
            if (campo.equals("Pernas") || campo.equals("PERNAS")) {

                options =
                    arrayOf("Exercicios", "Leg press ", "Agachamento na máquina", "Agachamento hack ", "Agachamento")
            }
        }
        verificaString(prencher)

        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        //Log.e("Teste","teste2")
        // Log.e("Teste3", "-")
        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                result.text = options.get(position)
                if (result.text.toString() == "Exercicios") {
                    repetir.text = "Selecione um Exercício"
                }
                if (result.text.toString() != "Exercicios") {
                    repetir.text = "4 x 12 Repetições"
                }
                count = 0 + 1
                if (result.text == "Exercicios") {
                    nrepetir.setText("Número De Repetições")
                }
                if (result.text != "Exercicios") {
                    nrepetir.setText("0")
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Teste"

            }

        }

        btncont.setOnClickListener() {
            if (result.text.toString() == "Exercicios") {
                Toast.makeText(
                    getApplicationContext(), "Por favor selecione um exercício ",
                    Toast.LENGTH_SHORT
                ).show();
                return@setOnClickListener
            }
            if (count >= 4) {
                nrepetir.setText("Terminaram suas repetições")
                Toast.makeText(
                    getApplicationContext(), "Você já encerrou esse exercício.",
                    Toast.LENGTH_SHORT
                ).show();
                return@setOnClickListener
            }
            if (count < 4) {
                nrepetir.setText(count.toString())
                count = count + 1
            }

        }
        btncont2.setOnClickListener() {
            if (result.text == "Exercicios") {
                Toast.makeText(
                    getApplicationContext(), "Por favor selecione um exercício",
                    Toast.LENGTH_SHORT
                ).show();
                return@setOnClickListener
            }
            nrepetir.setText("0")
            count = 0
            if (count == 0) {
                Toast.makeText(
                    getApplicationContext(), "A contagem já é zero",
                    Toast.LENGTH_SHORT
                ).show();
            }

        }
    }
}
