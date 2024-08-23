package com.sena.libreriaapi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Request.Method
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.sena.libreriaapi.config.urls

class ListarLibros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listar_libros)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cargar_lista_libros()
    }
    fun cargar_lista_libros(){
        try {
            var request = JsonArrayRequest(
                Request.Method.GET,
                urls.urlLibro,
                null,
                {response->
                    var registros= response
                    var recycler=findViewById<RecyclerView>(R.id.RVListarLibro)
                    recycler.layoutManager = LinearLayoutManager(applicationContext)
                    var adapter= adapterLibro(registros, this)
                    recycler.adapter=adapter
                },{error->
                    var registro=error
                }

            )
            val queue = Volley.newRequestQueue(this)
            queue.add(request)
        }catch (error:Exception){

        }
    }
}