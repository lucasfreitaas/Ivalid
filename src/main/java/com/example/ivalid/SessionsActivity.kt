package com.example.ivalid

import android.R.attr.data
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class SessionsActivity: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var menuIcon: ImageView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var breadcrumb: TextView
    private val EXTRA_SESSION_ID = "SESSION_ID"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_list)

        drawerLayout = findViewById(R.id.drawerlayout)
        navigationView = findViewById(R.id.navigationView)
        menuIcon = findViewById(R.id.menuIcon)
        recyclerView = findViewById(R.id.productsRecyclerView)
        breadcrumb = findViewById(R.id.breadcrumb)
        navigationView.setNavigationItemSelectedListener(this)

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        recyclerView.layoutManager = GridLayoutManager(this,2)
        productAdapter = ProductAdapter(emptyList())
        recyclerView.adapter = productAdapter

        val sessionId = intent.getIntExtra(EXTRA_SESSION_ID, -1)
        if (sessionId != - 1){
            loadSessionData(sessionId)
        }
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

            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

            intent.putExtra("SESSION_ID", sessionId)
            startActivity(intent)
        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    private fun navigateToHome() {
        val intent = Intent(this, InitialActivity::class.java).apply {
            // Flags para voltar à raiz da aplicação e limpar as Activities acima
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        }
        startActivity(intent)
    }


    override fun onNewIntent(intent: Intent){
        super.onNewIntent(intent)

        intent?.extras?.let {
            val newSessionId = it.getInt(EXTRA_SESSION_ID, -1)
            if (newSessionId != -1){
                loadSessionData(newSessionId)
            }
        }
    }

    private fun loadSessionData(id: Int) {
        val products: List<Product> = when (id) {
            10 -> {
                listOf(Product(101, "Vinho Tinto", "750ml", "R$ 35,00", "R$ 29,90", R.drawable.ic_vinho))
            }
            20 -> {
                listOf(Product(201, "Biscoito Cream Cracker", "200g", "R$ 5,00", "R$ 3,99", R.drawable.ic_biscoitos))
            }
            30 -> {
                listOf(Product(301, "Aveia em Flocos", "500g", "R$ 8,00", "R$ 6,50", R.drawable.ic_cereais))
            }
            40 -> emptyList()
            50 -> {
                listOf(Product(501, "Milho Verde Enlatado", "170g", "R$ 4,50", "R$ 3,50", R.drawable.ic_enlatados))
            }
            60 -> {
                listOf(
                    Product(601, "Queijo Muçarela", "200g", "R$ 15,00", "R$ 3,99", R.drawable.ic_queijo),
                    Product(602, "Presunto Sadia", "200g", "R$ 10,50", "R$ 8,99", R.drawable.ic_presunto)
                )
            }
            70 -> {
                listOf(Product(701, "Shampoo Anticaspa", "300ml", "R$ 25,00", "R$ 19,90", R.drawable.ic_higiene))
            }
            80 -> {
                listOf(Product(801, "Sabão em Pó", "1Kg", "R$ 12,00", "R$ 9,99", R.drawable.ic_limpeza))
            }
            90 -> {
                listOf(Product(901, "Arroz Agulhinha", "5Kg", "R$ 20,00", "R$ 17,50", R.drawable.ic_mercearia))
            }
            else -> emptyList()
        }

        val title = getSessioTitle(id)
        findViewById<TextView>(R.id.breadcrumb).text = title

        if (products.isEmpty()){
            print("Nenhum produto encontrado em $title.")
        } else {
            productAdapter.updateProducts(products)
            recyclerView.visibility = View.VISIBLE
        }
    }
    private fun getSessioTitle(id: Int): String {
        val base = "Página inicial > "
        return base + when(id){
            10 -> "Adega e Bebidas"
            20 -> "Biscoitos e Doces"
            30 -> "Cereais"
            40 -> "Congelados"
            50 -> "Enlatados"
            60 -> "Frios e Laticínios"
            70 -> "Higiene e Beleza"
            80 -> "Limpeza"
            90 -> "Mercearia"
            else -> "Categoria Desconhecida"
        }
    }
}