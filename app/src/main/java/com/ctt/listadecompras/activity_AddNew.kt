package com.ctt.listadecompras

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ctt.listadecompras.MainActivity.Companion.listaComprasMain
import com.ctt.listadecompras.model.listaCompras

class activity_AddNew : AppCompatActivity() {

    lateinit var itemTitle: EditText
    lateinit var itemQuant: EditText
    lateinit var botaoCad: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        itemTitle = findViewById(R.id.edtItem)
        itemQuant = findViewById(R.id.edtQnt)
        botaoCad = findViewById(R.id.btnAddItem)


        botaoCad.setOnClickListener {
            val itemTitleDig = itemTitle.text.toString()
            val itemQntDig = itemQuant.text.toString()
            val registro = listaCompras(itemTitleDig, itemQntDig)
            listaComprasMain.add(registro)
            confirmar(registro)

            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
            finish()
        }
    }

    fun confirmar(compra: listaCompras) {
        Toast.makeText(this, "Item cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
    }
}
