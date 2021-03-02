package com.ctt.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.listadecompras.model.ListaAdapter
import com.ctt.listadecompras.model.listaCompras

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaCompras = mutableListOf<listaCompras>(
            listaCompras(
                item = "Sabonete",
                quantidade = 5
            ),
            listaCompras(
                item = "Batata inglesa",
                quantidade = 4
            ),
            listaCompras(
                item = "Cenoura",
                quantidade = 3)
        )

        val rvCompras = findViewById<RecyclerView>(R.id.listaTarefas)
        val addItem = findViewById<Button>(R.id.btn_add)

        val adapterLista = ListaAdapter(listaCompras)
        rvCompras.adapter = adapterLista

        addItem.setOnClickListener{
            adapterLista.adicionarItem(
                listaCompras(item = "Chocolate", quantidade = 10)
            )
        }

        rvCompras.layoutManager = LinearLayoutManager(this)


    }
}