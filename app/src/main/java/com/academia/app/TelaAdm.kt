package com.academia.app

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.academia.app.Cliente
import com.academia.app.ClienteAdapter

//import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.tela_adm.*
import org.jetbrains.anko.appcompat.v7.toolbar

class TelaAdm : AppCompatActivity() {

    val ClienteList: MutableList<Cliente> = mutableListOf(
          Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
        , Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
        , Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
        , Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
        , Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
        , Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
        , Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
        , Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
        , Cliente("Cleito Rasta", 65.0, 1.70,"usuario","melhorquealok",true,12)
    )

    lateinit var ClienteAdapter: ClienteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_adm)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        ClienteAdapter = ClienteAdapter(this, ClienteList)
        recyclerViewCliente.adapter = ClienteAdapter
        recyclerViewCliente.layoutManager = LinearLayoutManager(this)
        recyclerViewCliente.smoothScrollToPosition(ClienteList.size)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)

        }
    }


}