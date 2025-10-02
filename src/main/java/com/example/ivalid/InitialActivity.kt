package com.example.ivalid

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class InitialActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var menuIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telainicial)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        menuIcon = findViewById(R.id.menu_icon)

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener(this)

        val products = listOf(
            Product(1, "Pão Tradicional", "400g", "R$ 7,00", "R$ 4,50", R.drawable.ic_pao),
            Product(2, "Leite Integral", "1L", "R$ 5,50", "R$ 3,99", R.drawable.ic_leite),
            Product(3, "Doritos", "75G", "R$ 12,00", "R$ 5,50", R.drawable.ic_doritos),
        )

        val recyclerView: RecyclerView = findViewById(R.id.products_recycler_view_1)


        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapter = ProductAdapter(products)
        recyclerView.adapter = adapter

        val frios = listOf(
            Product(4, "Queijo Muçarela", "200g", "R$ 15,00", "R$ 3,99", R.drawable.ic_queijo),
            Product(5, "Presunto Sadia", "200g", "R$ 10,50", "R$ 8,99", R.drawable.ic_presunto),
            Product(6, "Salsicha Sadia", "3KG", "R$ 22,00", "R$ 19,90", R.drawable.ic_salsicha),
        )

        val rvFrios: RecyclerView = findViewById(R.id.products_recycler_view_2)

        rvFrios.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFrios.adapter = ProductAdapter(frios )
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        val menuId = item.itemId

        val sessionId: Int = when(menuId){
            R.id.nav_adega      -> 10
            R.id.nav_biscoitos  -> 20
            R.id.nav_cereais    -> 30
            R.id.nav_congelados -> 40
            R.id.nav_enlatados  -> 50
            R.id.nav_frios      -> 60
            R.id.nav_higiene    -> 70
            R.id.nav_limpeza    -> 80
            R.id.nav_mercearia  -> 90
            else                -> -1
        }

        if(sessionId != -1){
            val intent = Intent(this, SessionsActivity::class.java)

            intent.putExtra("SESSION_ID", sessionId)
            startActivity(intent)
        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
}