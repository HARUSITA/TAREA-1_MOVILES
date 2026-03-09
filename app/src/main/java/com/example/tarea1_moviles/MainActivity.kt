package com.example.tarea1_moviles

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configuración para que el contenido no se encime con la barra de estado/navegación
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0) // Padding inferior 0 para que el BottomNav se pegue abajo
            insets
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // 1. Cargar el fragment por defecto al abrir la app (TextFields)
        if (savedInstanceState == null) {
            replaceFragment(FragmentText())
        }

        // 2. Escuchar los clics del menú
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_text -> replaceFragment(FragmentText())
                R.id.nav_buttons -> replaceFragment(FragmentButtons())
                R.id.nav_selection -> replaceFragment(FragmentSelection())
                R.id.nav_list -> replaceFragment(FragmentList())
                R.id.nav_info -> replaceFragment(FragmentInformation())
            }
            true
        }
    }

    // Función auxiliar para cambiar fragments de forma limpia
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .setTransition(androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }
}

