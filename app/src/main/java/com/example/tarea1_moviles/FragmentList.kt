package com.example.tarea1_moviles

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentList : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<ListView>(R.id.list_view_demo)

        // 1. Catálogo de procedimientos IT
        val procedimientos = arrayOf(
            "Configuración de equipos",
            "Instalación de impresoras",
            "Configuración de usuarios",
            "Alta de un nuevo usuario",
            "Migración de datos y archivos"
        )

        // 2. Configurar el adaptador
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, procedimientos)
        listView.adapter = adapter

        // 3. Listener ÚNICO para el clic en la lista
        listView.setOnItemClickListener { _, _, position, _ ->
            val procedimientoSeleccionado = procedimientos[position]

            // A. Recuperar nombre y mostrar confirmación
            val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val nombre = sharedPref.getString("USER_NAME", "Becario")
            Toast.makeText(requireContext(), "$nombre, abriendo: $procedimientoSeleccionado", Toast.LENGTH_SHORT).show()

            // B. Guardar el procedimiento seleccionado para que el Fragment de Información lo sepa
            with(sharedPref.edit()) {
                putString("PROCEDIMIENTO_ACTUAL", procedimientoSeleccionado)
                apply()
            }

            // C. Navegar automáticamente a la pestaña de Información (Perfil IT)
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
            bottomNav.selectedItemId = R.id.nav_info
        }
    }
}