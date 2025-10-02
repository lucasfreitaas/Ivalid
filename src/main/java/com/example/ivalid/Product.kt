package com.example.ivalid

data class Product( // MUDANÇA: Use 'data class' e coloque tudo aqui.
    val id: Int,
    val name: String,
    val quantity: String,
    val oldPrice: String,
    val newPrice: String,
    val imageResourceId: Int // Armazena o R.drawable.nome_da_imagem
)