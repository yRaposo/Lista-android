package com.example.myapplication

import android.os.Bundle;
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity;

class ContatoActivity(): AppCompatActivity() {

    //val lista : List<Contato> = mutableListOf();
    val lista = mutableListOf<Contato>()

    override  fun onCreate(bundle: Bundle?){
        super.onCreate(bundle);

        setContentView(R.layout.contato_activity);

        val nome = findViewById<EditText>(R.id.inputNome);
        val tell = findViewById<EditText>(R.id.inputTell);
        val mail = findViewById<EditText>(R.id.inputEmail);

        val btnSalvar = findViewById<Button>(R.id.btnSalvar);

        val lstViewContatos = findViewById<ListView>(R.id.lstContatos);

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstViewContatos.adapter = adapter;

        btnSalvar.setOnClickListener{
            val c1 = Contato(
                nome.text.toString(),
                tell.text.toString(),
                mail.text.toString()
                )
            lista.add(c1)
            adapter.clear()

            for( contato in lista) {
                adapter.addAll(contato.toString())
            }
            adapter.addAll(lista.toString())
            Log.i("Agenda_contato","Lista: ${lista}")
        }
    }
}