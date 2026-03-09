package com.example.tarea1_moviles

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentInformation : Fragment(R.layout.fragment_information) {

    // ESTA DEBE SER LA ÚNICA FUNCIÓN onViewCreated EN EL ARCHIVO
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Recuperar datos de SharedPreferences
        val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val nombre = sharedPref.getString("USER_NAME", "Becario")
        val procedimiento = sharedPref.getString("PROCEDIMIENTO_ACTUAL", "Ninguno")

        // 2. Referencias a la interfaz
        val tvUser = view.findViewById<TextView>(R.id.tv_user_name_display)
        val tvTitulo = view.findViewById<TextView>(R.id.tv_titulo_procedimiento)
        val tvDetalle = view.findViewById<TextView>(R.id.tv_detalle_procedimiento)
        val progressBar = view.findViewById<ProgressBar>(R.id.pb_demo)
        val btnModify = view.findViewById<Button>(R.id.btn_modify_procedure)

        // 3. Asignar los valores básicos y el texto dinámico
        tvUser?.text = nombre
        tvTitulo?.text = procedimiento

        tvDetalle?.text = when (procedimiento) {
            "Configuración de equipos" -> {
                "• Revisar especificaciones de hardware.\n• Cargar imagen del sistema operativo.\n• Unir equipo al dominio corporativo."
            }
            "Instalación de impresoras" -> {
                "• Conectar equipo a la red local.\n• Instalar controladores específicos.\n• Realizar prueba de impresión y duplex."
            }
            "Configuración de usuarios" -> {
                "• Crear cuenta en Active Directory.\n• Asignar grupos de permisos.\n• Configurar perfiles de correo institucional."
            }
            "Alta de un nuevo usuario" -> {
                "• Registro en inventario de activos.\n• Entrega de equipo y periféricos.\n• Firma de responsiva de herramientas IT."
            }
            "Migración de datos y archivos" -> {
                "• Respaldo de perfiles de usuario antiguos.\n• Transferencia segura de datos vía red.\n• Validación de integridad de los archivos."
            }
            else -> "Vuelve a la pestaña Bitácora y elige un procedimiento para ver los pasos técnicos."
        }

        // 4. Iniciar la animación de la barra de carga
        if (progressBar != null) {
            animarProgressBar(progressBar)
        }

        // 5. Configurar la navegación del botón "Modificar" hacia el Fragment de Botones
        btnModify?.setOnClickListener {
            // Accedemos al BottomNavigationView de la Activity principal para cambiar de pestaña
            val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)

            // Cambiamos el ID seleccionado al de 'Acciones' (asegúrate que este ID coincida con tu menu.xml)
            bottomNav.selectedItemId = R.id.nav_buttons
        }
    }

    private fun animarProgressBar(pb: ProgressBar) {
        var progressStatus = 0
        val handler = Handler(Looper.getMainLooper())
        Thread {
            while (progressStatus < 100) {
                progressStatus += 2
                handler.post { pb.progress = progressStatus }
                try {
                    Thread.sleep(20)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }.start()
    }
}