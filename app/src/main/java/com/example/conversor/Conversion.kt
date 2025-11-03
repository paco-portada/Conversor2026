package com.example.conversor

object Conversion {
    @Throws(NumberFormatException::class)
    fun convertirADolares(cantidad: String, cambio: Double): String {
        val valor = cantidad.toDouble() / cambio
        return java.lang.Double.toString(valor)
        //return String.valueOf(valor);
    }

    @Throws(NumberFormatException::class)
    fun convertirAEuros(cantidad: String, cambio: Double): String {
        val valor = cantidad.toDouble() * cambio
        return String.format("%.2f", valor)
    }
}