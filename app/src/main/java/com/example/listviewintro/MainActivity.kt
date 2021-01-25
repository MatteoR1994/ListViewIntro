package com.example.listviewintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaElementi: MutableList<Data> = mutableListOf()
        listaElementi.add(Data("happy_kid",R.drawable.paesaggio1,"pernacchia"))
        listaElementi.add(Data("happy_kid",R.drawable.paesaggio2,"pernacchia"))
        listaElementi.add(Data("happy_kid",R.drawable.paesaggio3,"pernacchia"))
        listaElementi.add(Data("happy_kid",R.drawable.paesaggio4,"pernacchia"))
        listaElementi.add(Data("happy_kid",R.drawable.paesaggio5,"pernacchia"))

        val customAdapter = CustomAdapter(listaElementi)
        imagesList.adapter = customAdapter
    }
}