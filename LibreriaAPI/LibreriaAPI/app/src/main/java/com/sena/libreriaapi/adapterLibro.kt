package com.sena.libreriaapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

class adapterLibro
    (
           var listarLibros: JSONArray,
            var context: Context
            )

    : RecyclerView.Adapter<adapterLibro.ViewHolder>()


{

        inner class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView)
        {
            lateinit var txtTitulo: TextView
            lateinit var txtAutor: TextView
            lateinit var btnEditar: Button
            lateinit var btnEliminar:Button

            init {
                txtTitulo=itemView.findViewById(R.id.txtTitulo)
                txtAutor=itemView.findViewById(R.id.txtAutor)
                btnEditar=itemView.findViewById(R.id.btnEditar)
                btnEliminar=itemView.findViewById(R.id.btnEliminar)
            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterLibro.ViewHolder {
        var itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_libro, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterLibro.ViewHolder, position: Int) {
        var Libro=listarLibros.getJSONObject(position)
        holder.txtTitulo.text=Libro.getString("titulo")
        holder.txtAutor.text=Libro.getString("autor")
    }

    override fun getItemCount(): Int {
        return listarLibros.length()
    }
}