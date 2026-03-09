package com.example.tarea1_moviles

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment

class FragmentSelection : Fragment(R.layout.fragment_selection) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkBox = view.findViewById<CheckBox>(R.id.cb_demo)
        val radioGroup = view.findViewById<RadioGroup>(R.id.rg_demo)
        val switchDemo = view.findViewById<Switch>(R.id.sw_demo)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            val msg = if (isChecked) "Aceptado" else "Cancelado"
            Toast.makeText(requireContext(), "Términos: $msg", Toast.LENGTH_SHORT).show()
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selected = view.findViewById<RadioButton>(checkedId)
            Toast.makeText(requireContext(), "Elegiste: ${selected.text}", Toast.LENGTH_SHORT).show()
        }

        switchDemo.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(requireContext(), "Notificaciones: $isChecked", Toast.LENGTH_SHORT).show()
        }
    }
}