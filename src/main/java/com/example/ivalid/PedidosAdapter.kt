package com.example.ivalid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PedidosAdapter(private val listaPedidos: List<Pedido>) :
    RecyclerView.Adapter<PedidosAdapter.PedidoViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PedidoViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pedido, parent, false)
        return PedidoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        val pedido = listaPedidos[position]
        holder.bind(pedido)
    }

    override fun getItemCount() = listaPedidos.size

    inner class PedidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val valorTotal: TextView = itemView.findViewById(R.id.pedido_valor_total)
        private val numeroPedido: TextView = itemView.findViewById(R.id.pedido_numero)
        private val statusPedido: TextView = itemView.findViewById(R.id.pedido_status)

        fun bind(pedido: Pedido){
            valorTotal.text = pedido.valorTotal
            numeroPedido.text = "Pedido: #${pedido.numero}"

            when(pedido.status){
                "AGUARDANDO" ->{
                    statusPedido.text = "AGUARDANDO CONFIRMAÇÃO"
                    statusPedido.setBackgroundResource(R.drawable.status_aguardando)
                }
                "SEPARACAO" -> {
                    statusPedido.text = "PEDIDO EM SEPARAÇÃO"
                    statusPedido.setBackgroundResource(R.drawable.status_separacao)
                }
                "ENTREGA" -> {
                    statusPedido.text = "EM ROTA DE ENTREGA"
                    statusPedido.setBackgroundResource(R.drawable.status_entrega)
                }
                else -> {
                    statusPedido.text = pedido.status
                    statusPedido.setBackgroundResource(R.drawable.status_aguardando)
                }
            }
        }
    }
}