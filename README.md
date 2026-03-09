# 🛠️ Guía Interactiva para Becarios IT - ESCOM

Este proyecto es una aplicación móvil desarrollada en **Android Studio** utilizando **Kotlin** para la materia de Programación de Dispositivos Móviles. La app funciona como una herramienta de inducción interactiva para becarios del Departamento de Sistemas.

## 🚀 Funcionalidades Principales

* **Registro de Perfil:** El usuario ingresa su nombre, el cual se persiste en toda la aplicación mediante `SharedPreferences`.
* **Bitácora de Procedimientos:** Una lista dinámica (`ListView`) con los procesos técnicos más comunes (Configuración de equipos, Instalación de impresoras, etc.).
* **Visualización Dinámica:** Al seleccionar un proceso, la app navega automáticamente a la pestaña de Información, desplegando los pasos técnicos específicos.
* **Panel de Edición:** Permite al becario modificar en tiempo real el título y la descripción de los procedimientos, sobrescribiendo los datos por defecto.
* **Navegación Intuitiva:** Implementación de `BottomNavigationView` para transiciones fluidas entre las 5 interfaces principales.

## 📱 Capturas de Pantalla
> *Sugerencia: Sube las imágenes de tu app a una carpeta llamada `screenshots` en GitHub y vincúlalas aquí.*

| Registro | Bitácora | Información IT |
| :---: | :---: | :---: |
| ![Registro](screenshots/registro.png) | ![Lista](screenshots/lista.png) | ![Info](screenshots/info.png) |

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Kotlin
* **Interfaz:** XML con Material Design 3
* **Arquitectura:** Single Activity con 5 Fragmentos
* **Persistencia:** SharedPreferences para manejo de sesión y datos temporales
* **Componentes:**
    * `BottomNavigationView` para navegación global
    * `ConstraintLayout` para diseños responsivos
    * `ProgressBar` con hilos (`Thread`) para simulación de procesos

## 📝 Instrucciones de Uso
1. **Pestaña 1:** Ingresa tu nombre de becario y presiona "Guardar".
2. **Pestaña 4:** Selecciona cualquier procedimiento técnico de la lista.
3. **Pestaña 5:** Revisa los detalles técnicos y observa la barra de sincronización.
4. **Modificación:** Desde la pestaña 5, usa el botón "Modificar" para saltar a la pestaña 2 y personalizar la información técnica.

---
**Desarrollado por:** Harusitaaa  
**Institución:** Escuela Superior de Cómputo (ESCOM - IPN)  
**Fecha:** Marzo 2026
