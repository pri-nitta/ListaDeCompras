package com.ctt.listadecompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.listadecompras.model.ListaAdapter
import com.ctt.listadecompras.model.ListaCompras

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvCompras = findViewById<RecyclerView>(R.id.listaTarefas)
        val addItem = findViewById<Button>(R.id.btn_add)

        val adapterLista = ListaAdapter(listaComprasMain)
        rvCompras.adapter = adapterLista

        addItem.setOnClickListener {
            val intent = Intent(this, Activity_AddNew::class.java)
            startActivity(intent)
            finish()
        }
        rvCompras.layoutManager = LinearLayoutManager(this)
    }

    companion object {
        val listaComprasMain = mutableListOf<ListaCompras>()
    }
}