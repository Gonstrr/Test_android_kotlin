package com.example.fundamentoskotlin

fun main() {
    val nombre = "Gonzalo Salas Tranolao"
    val productos = mutableListOf("Coca Cola", "Pepsi", "Fanta", "Sprite")

    showProductos(productos, "Sprite")
}

fun insertarProducto(productos: MutableList<String>, nuevoProducto: String) {
    productos.add(nuevoProducto)
}

fun showProductos(productos: List<String>, productoABuscar: String) {
    productos.forEach { println(it) }

    productos.forEachIndexed { index, producto ->
        println("Producto $index: $producto")

        if (producto.equals(productoABuscar, ignoreCase = true)) {
            println("Producto: $producto encontrado")
        }
    }
}



