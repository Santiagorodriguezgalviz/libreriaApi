package com.sena.libreriaapi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.JsonObject
import com.sena.libreriaapi.Entity.book
import com.sena.libreriaapi.config.urls
import org.json.JSONObject

class guardarLibroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_guardar_libro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val libro=book(
            0,
            "El mostro sesi",
            "Albarito",
            1243243543234,
            "Novela sesi",
            100,
            0

        )
        guardarLibro(libro)
    }

    //tarea crear el formulario para el registro
    fun guardarLibro(libro: book){

        try {
            //se crean los parametros
            var parametros = JSONObject()
            //parametros.put("nombre_variable", "valor")
            parametros.put("titulo", libro.titulo)
            parametros.put("autor", libro.autor)
            parametros.put("isbn", libro.isbn)
            parametros.put("genero", libro.genero)
            parametros.put("num_ejem_disponible", libro.num_ejem_disponible)
            parametros.put("num_ejem_ocupados", libro.num_ejem_ocupados)

            var request = JsonObjectRequest(
                Request.Method.POST,
                urls.urlLibro,
                parametros,
                {response->
                    Toast.makeText(this, "SE GUARDÓ CORRECTAMENTE, BEBÉ", Toast.LENGTH_LONG).show()
                },
                {error->
                    Toast.makeText(this, "Se generó un error, bebé", Toast.LENGTH_LONG).show()
                }

            )
            val queue = Volley.newRequestQueue(this)
            queue.add(request)
        }catch (error:Exception){

        }

    }
}