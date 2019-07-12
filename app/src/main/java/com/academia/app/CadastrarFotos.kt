package com.academia.app

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.media.audiofx.EnvironmentalReverb
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.storage.StorageManager
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.widget.Button
import kotlinx.android.synthetic.main.activity_cadastrar_fotos.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class CadastrarFotos : AppCompatActivity() {
    var currentPath : String? = null
    var TAKE_PICTURE = 1
    lateinit var btncamera : Button
    lateinit var btngaleria : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cadastrar_fotos)
        btncamera = findViewById(R.id.botaocamera) as Button
        btngaleria = findViewById(R.id.botaogaleria) as Button

        btncamera.setOnClickListener() {
            DispatchCameraIntent()
        }
        btngaleria.setOnClickListener() {

        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode ==TAKE_PICTURE && resultCode == Activity.RESULT_OK){
                try {
                    val file = File(currentPath)
                    val uri = Uri.fromFile(file)
                    imageView2.setImageURI(uri)
                }catch (e: IOException){
                    e.printStackTrace()
                }
            }
        }

    }

    fun DispatchCameraIntent(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(packageManager) != null){
            var photofile : File? = null
            try {
                photofile = criarImagem()
            }catch (e: IOException){
                e.printStackTrace()
            }
            if(photofile != null){
                // Tem que criar um conteudo para autoridade "content" no manifest"
                var photoUri = FileProvider.getUriForFile(this, "com.coutocode.cameraexample.fileprovider",photofile)
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
                startActivityForResult(intent,TAKE_PICTURE)
            }
        }
    }

    fun criarImagem(): File{
        val timeStamp = SimpleDateFormat("yyyyMMDD_HHmmss").format(Date())
        val imagename = "JPEG_" + timeStamp+"_"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES) // Diretório a ser guardado
        var image = File.createTempFile(imagename,"jpg", storageDir )
        currentPath = image.absolutePath
        return image
    }
}