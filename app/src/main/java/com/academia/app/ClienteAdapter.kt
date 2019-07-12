package com.academia.app

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.academia.app.R
import kotlinx.android.synthetic.main.cliente_item.view.*

class ClienteAdapter(private val context: Context, private var clienteList: MutableList<Cliente>):
    RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cliente_item, parent, false)
        return ClienteViewHolder(view)
    }

    override fun getItemCount() = clienteList.size

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        holder.bindView(clienteList[position])
    }

    class ClienteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewNome = itemView.textViewNome
        val textViewStatus = itemView.textViewStatus


        fun bindView(cliente: Cliente) {
            textViewNome.text = cliente.nome
            if(cliente.status==true){
                textViewStatus.text = "Regularizado"
            }
            if(cliente.status==false){
                textViewStatus.text = "Pendências"
            }



        }
    }
}