package com.ctt.listadecompras.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.listadecompras.R

class ListaAdapter(private val listaCompras: MutableList<listaCompras>): RecyclerView.Adapter<ListaAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val item: TextView = view.findViewById(R.id.txt_content)
        val quantidade: TextView = view.findViewById(R.id.txt_quantidade)
    }

    fun adicionarItem(novoItem: listaCompras){
        listaCompras.add(novoItem)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.text= listaCompras[position].item
        holder.quantidade.text = listaCompras[position].quantidade.toString()
    }

    override fun getItemCount(): Int {
        return listaCompras.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).
                inflate(R.layout.activity_lista_compras, parent, false)
        return ViewHolder(view)

    }

}