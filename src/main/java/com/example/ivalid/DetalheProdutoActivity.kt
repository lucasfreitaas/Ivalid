/*
package com.example.ivalid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ivalid.databinding.ActivityDetalheProdutoBinding
import com.example.ivalid.databinding.ItemProductBinding

class DetalheProdutoActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetalheProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val produtoAtual = Product(
            id = 1,
            name = "Mussarela Italac 400G",
            oldPrice = "10.00",
            newPrice = "5.99",
            daysValidity = 8, // Exemplo: 8 dias para vencimento (VERMELHO)
            imageResourceId = R.drawable.ic_queijo,
            quantity = "5"
        )

        exibirDetalhesDoProduto(produtoAtual)

        binding.cardDetalheProduto.btnAdicionarCarrinho.setOnClickListener {

        }
    }

    private fun exibirDetalhesDoProduto(product: Product){
        val cardBinding = binding.cardDetalheProduto

        cardBinding.ivProdutoPrincipal.setImageResource(product.imageResourceId)
        cardBinding.tvNomeProduto.text = product.name
        cardBinding.tvPrecoAntigo.text = getString(R.string.preco_formatado, product.oldPrice)
        cardBinding.tvPrecoAtual.text = getString(R.string.preco_formatado, product.newPrice)
        cardBinding.tvPrecoAntigo.paintFlags = cardBinding.tvPrecoAntigo.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
        configurarValidade(product.daysValidity)

        if(product.newPrice < product.oldPrice * 0.6){
            cardBinding.backIcon.visibility = View.VISIBLE
        } else {
            cardBinding.cartIcon.visibility = View.VISIBLE
        }
    }

    private fun configurarValidade(diasRestantes: Int){
        val avisoTextView = binding.cardDetalheProduto.avisoValidade.txtValidade

        avisoTextView.text = getString(R.string.aviso_validade_formatado, diasRestantes)

        val drawableResource: Int = when {
            diasRestantes <= 10 -> R.drawable.bg_red
            diasRestantes <= 30 -> R.drawable.bg_yellow
            else -> R.drawable.bg_green
        }

        avisoTextView.setBackgroundResource(drawableResource)
    }
}*/
