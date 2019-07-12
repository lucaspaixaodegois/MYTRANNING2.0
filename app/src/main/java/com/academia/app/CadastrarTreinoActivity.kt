package com.academia.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_cadastrar_treino.*

class CadastrarTreinoActivity : AppCompatActivity() {
   // lateinit var txtnome : EditText
    lateinit var txtpeso : EditText
    lateinit var txtaltura : EditText
    lateinit var txtlogin : EditText
    lateinit var txtsenha : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_treino)
      //  txtnome = findViewById(R.id.nome)
        txtpeso = findViewById(R.id.peso)
        txtaltura = findViewById(R.id.altura)
        txtlogin = findViewById(R.id.login)
        txtsenha = findViewById(R.id.senha)
      //  var intent = intent
       // txtnome.setText(intent.getStringExtra("nome"))

        val usuario = intent.getSerializableExtra("usuario") as ListUsuario

        nome.setText(usuario.usuarios[0].nome)
       login.setText(usuario.usuarios[0].login)
        senha.setText(usuario.usuarios[0].senha)
        altura.setText(usuario.usuarios[0].altura.toString())
        peso.setText(usuario.usuarios[0].peso.toString())
    }
}
