package com.sena.libreriaapi.Entity

data class book(
    var id:Int,
    var titulo:String,
    var autor:String,
    var isbn:Long,
    var genero:String,
    var num_ejem_disponible:Int,
    var num_ejem_ocupados:Int
)
