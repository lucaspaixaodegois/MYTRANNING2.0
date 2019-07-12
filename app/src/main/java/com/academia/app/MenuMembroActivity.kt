package com.academia.app
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuMembroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_membro)
        var btnExercicioAbdominais = findViewById<Button>(R.id.btnAbdominal)
        var btnExercicioAntebracos = findViewById<Button>(R.id.btnAntebracos)
        var btnExercicioBiceps = findViewById<Button>(R.id.btnBiceps)
        var btnExercicioCostas = findViewById<Button>(R.id.btnCostas)
        var btnExercicioPeito = findViewById<Button>(R.id.btnPeito)
        var btnExercicioPernas = findViewById<Button>(R.id.btnPernas)
        var btnCadExercicio = findViewById<Button>(R.id.btnCadTreino)

//        var btnExercicioVoltar = findViewById<Button>(R.id.btnVoltar)
//        btnExercicioVoltar.setOnClickListener { voltar() }

//        var btnExercicioAbdominal = findViewById<Button>(R.id.btnAbdominal)
//        btnExercicioAbdominal.setOnClickListener { abdominal() }

//        btnCadExercicio.setOnClickListener { CadastrarTreino() }

        btnExercicioPernas.setOnClickListener { Pernas() }

        btnExercicioAntebracos.setOnClickListener(){ Antebracos() }

        btnExercicioAbdominais.setOnClickListener(){ Abdominais() }

        btnExercicioBiceps.setOnClickListener(){ Biceps() }

        btnExercicioCostas.setOnClickListener(){ Costas() }

        btnExercicioPeito.setOnClickListener(){ Abdominais() }



    }

    fun voltar() {
        var intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }
    fun Abdominais() {
        var intent = Intent(applicationContext, ExercicioAbdominalActivity::class.java)
        startActivity(intent)
    }
    fun Antebracos() {
        var intent = Intent(applicationContext, ExercicioAntebracosActivity::class.java)
        startActivity(intent)
    }
    fun Biceps() {
        var intent = Intent(applicationContext, ExcercicioBicepsActivity::class.java)
        startActivity(intent)
    }
    fun Costas() {
        var intent = Intent(applicationContext, ExcercicioCostaActivity::class.java)
        startActivity(intent)
    }
    fun Peito() {
        var intent = Intent(applicationContext, ExercicioPernasActivity::class.java)
        startActivity(intent)
    }

    fun Pernas() {
        var intent = Intent(applicationContext, ExercicioPernasActivity::class.java)
        startActivity(intent)
    }
//    fun CadastrarTreino() {
//        var intent = Intent(applicationContext, AvatarMenuMembroActivity::class.java)
//        startActivity(intent)
//    }
}