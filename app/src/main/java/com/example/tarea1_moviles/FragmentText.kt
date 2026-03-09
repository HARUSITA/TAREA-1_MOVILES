package com.example.tarea1_moviles

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentText : Fragment(R.layout.fragment_text) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Referencias a los componentes del XML
        val etNombre = view.findViewById<TextInputEditText>(R.id.et_demo)
        val btnGuardar = view.findViewById<Button>(R.id.btn_show_text)
        val btnNext = view.findViewById<Button>(R.id.btn_next_interface)

        // 2. Lógica para Guardar el Nombre
        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()

            if (nombre.isNotEmpty()) {
                val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("USER_NAME", nombre)
                    apply()
                }
                Toast.makeText(requireContext(), "¡Hola $nombre! Perfil de Becario actualizado.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Por favor, ingresa tu nombre", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Lógica para Navegar a la Bitácora (Paso a paso)
        btnNext.setOnClickListener {
            val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val nombre = sharedPref.getString("USER_NAME", "")

            if (nombre.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Ingresa tu nombre para personalizar tu guía", Toast.LENGTH_SHORT).show()
            } else {
                // Accedemos al menú inferior de la MainActivity
                val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)

                // Cambiamos al ID de la lista/bitácora definido en tu menú
                bottomNav.selectedItemId = R.id.nav_list
            }
        }
    }
}