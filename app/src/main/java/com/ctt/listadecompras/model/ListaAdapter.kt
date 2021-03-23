package com.ctt.listadecompras.model

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.listadecompras.R

class ListaAdapter(private val ListaCompras: MutableList<ListaCompras>): RecyclerView.Adapter<ListaAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val item: TextView = view.findViewById(R.id.txt_content)
        val quantidade: TextView = view.findViewById(R.id.txt_quantidade)
    }

    fun adicionarItem(novoItem: ListaCompras){

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.text = ListaCompras[position].item
        holder.quantidade.text = ListaCompras[position].quantidade

        holder.itemView.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("Item")
            builder.setMessage("Você deseja realmente deletar essa tarefa?")
            builder.setPositiveButton("Yeap!") { dialog, which ->
                ListaCompras.removeAt(position)
                notifyDataSetChanged()
            }
            builder.setNegativeButton("Nens") { dialog, which -> }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return ListaCompras.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).
                inflate(R.layout.activity_lista_compras, parent, false)
        return ViewHolder(view)

    }

}