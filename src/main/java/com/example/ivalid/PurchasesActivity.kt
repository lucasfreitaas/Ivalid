package com.example.ivalid

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView


class PurchasesActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.purchases)


        drawerLayout = findViewById(R.id.drawer_layout_compras)
        val menuIcon: ImageView = findViewById(R.id.menuIcon)
        val navigationView: NavigationView = findViewById(R.id.navigation_view_compras)

        navigationView.setNavigationItemSelectedListener(this)

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val recyclerView: RecyclerView = findViewById(R.id.pedidos_recycler_view)

        val listaDePedidos = listOf(
            Pedido(numero = "12345", valorTotal = "R$ 155,90", status = "AGUARDANDO"),
            Pedido(numero = "12346", valorTotal = "R$ 89,50", status = "SEPARACAO"),
            Pedido(numero = "12347", valorTotal = "R$ 210,35", status = "ENTREGA")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PedidosAdapter(listaDePedidos)
        recyclerView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        val menuId = item.itemId

        when(menuId){
            R.id.nav_inicio -> {
                navigateToHome()
            }

            R.id.nav_adega      -> openSession(10)
            R.id.nav_biscoitos  -> openSession(20)
            R.id.nav_cereais    -> openSession(30)
            R.id.nav_congelados -> openSession(40)
            R.id.nav_enlatados  -> openSession(50)
            R.id.nav_frios      -> openSession(60)
            R.id.nav_higiene    -> openSession(70)
            R.id.nav_limpeza    -> openSession(80)
            R.id.nav_mercearia  -> openSession(90)
        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    private fun openSession(sessionId: Int){
        val intent = Intent(this, SessionsActivity::class.java).apply{
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            putExtra("SESSION_ID", sessionId)
        }
        startActivity(intent)
    }

    private fun navigateToHome(){
        val intent = Intent(this, InitialActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }
}