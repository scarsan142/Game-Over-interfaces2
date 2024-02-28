package com.marisma.gameover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.NavDeepLinkRequest
import androidx.core.net.toUri
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.marisma.gameover.databinding.ActivityMainBinding
import com.marisma.gameover.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcwMain) as NavHostFragment
        navController = navHostFragment.navController

        drawerLayout = findViewById(R.id.drawer_layout)

        setupNavigationMenu()

        // Habilitar el botón de navegación hacia arriba (up button)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)


        /*_binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavegacion()*/
        //Codigo del bottom menu
        findViewById<BottomNavigationView>(R.id.bottom_nav).setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
    }


    /*private fun setupNavegacion(){
        val bottomNavigationView = binding.bottomNav
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcwMain) as NavHostFragment
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment.navController
        )
    }*/

    private fun setupNavigationMenu() {
        val binding = com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.ItemListMenu -> {
                    // Usar el URI del enlace profundo para itemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/ItemListFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.FavItemListMenu -> {
                    // Usar el URI del enlace profundo para favItemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/FavItemListFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }R.id.UserInfoMenu -> {
                    // Usar el URI del enlace profundo para favItemListFragment
                    val request = NavDeepLinkRequest.Builder
                        .fromUri("android-app://com.marisma.gameover/UserInfoFragmentFragment".toUri())
                        .build()
                    navController.navigate(request)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }

        val navigationView: com.google.android.material.navigation.NavigationView = findViewById(R.id.drawer_nav)
        navigationView.setNavigationItemSelectedListener(binding)
    }
}
