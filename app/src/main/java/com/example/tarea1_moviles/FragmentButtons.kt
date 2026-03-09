package com.example.tarea1_moviles

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

class FragmentButtons : Fragment(R.layout.fragment_buttons) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        // Referencias a los campos de texto
        val etTitle = view.findViewById<TextInputEditText>(R.id.et_new_title)
        val etDetail = view.findViewById<TextInputEditText>(R.id.et_new_detail)

        // Referencias a los botones
        val btnUpdateTitle = view.findViewById<Button>(R.id.btn_update_title)
        val btnUpdateDetail = view.findViewById<Button>(R.id.btn_update_detail)

        // Lógica para cambiar Título
        btnUpdateTitle.setOnClickListener {
            val nuevoTitulo = etTitle.text.toString().trim()
            if (nuevoTitulo.isNotEmpty()) {
                sharedPref.edit().putString("PROCEDIMIENTO_ACTUAL", nuevoTitulo).apply()
                Toast.makeText(context, "Título actualizado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Escribe un título válido", Toast.LENGTH_SHORT).show()
            }
        }

        // Lógica para cambiar Información técnica
        btnUpdateDetail.setOnClickListener {
            val nuevaInfo = etDetail.text.toString().trim()
            if (nuevaInfo.isNotEmpty()) {
                // Usamos una nueva llave para que FragmentInformation la reconozca como "personalizada"
                sharedPref.edit().putString("DETALLE_PERSONALIZADO", nuevaInfo).apply()
                Toast.makeText(context, "Detalles técnicos actualizados", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Escribe la descripción", Toast.LENGTH_SHORT).show()
            }
        }
    }
}