package com.academia.app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var fbAuth = FirebaseAuth.getInstance()

    lateinit var tLogin: EditText
    lateinit var tSenha: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tLogin = findViewById(R.id.editTextLogin)
        tSenha = findViewById(R.id.editTextSenha)


        var btEntrar = findViewById<Button>(R.id.btnEntrar)
        btEntrar.setOnClickListener {
            //val usuario = intent.getSerializableExtra("usuario") as ListUsuario
            Logar(tLogin, tSenha)
        }

        var btCadastrar = findViewById<Button>(R.id.btnCadastrar)
        btCadastrar.setOnClickListener {
            //     Cadastrar()
        }

        var btLimpar = findViewById<Button>(R.id.btnLimpar)
        btLimpar.setOnClickListener {
            Limpar()
        }
    }


    fun Logar(tLogin: EditText, tSenha: EditText) {

        var login = tLogin.text.toString()
        var senha = tSenha.text.toString()

        alert("Autenticando...")

        fbAuth.signInWithEmailAndPassword(login, senha)
            .addOnCompleteListener(this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {

                    var intent = Intent(applicationContext, Menu::class.java)
                    startActivity(intent)
                    intent.putExtra("id", fbAuth.currentUser?.email)
                    alert("Bem Vindo, Acesso Realizado com Sucesso.")

                } else {
                    alert("Error: Login e/ou Senha Incorretos.")
                }
            })
    }


    fun Cadastrar() {
        var intent = Intent(this, CadastroActivity::class.java)
        startActivityForResult(intent, 0)

    }
// //Esssa está funcionando
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode==0){
//            str = data?.getStringExtra("nome")
//            tLogin.setText(str)
//        }
//    }


    //    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode==0){
//            val usuario = intent.getSerializableExtra("usuario") as ListUsuario
//            tLogin.setText(usuario.usuarios[0].login)
//
//        }
//    }
    fun Limpar() {

        editTextLogin.setText("")
        editTextSenha.setText("")
        editTextLogin.requestFocus()

    }

    fun alert(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

    }

}






