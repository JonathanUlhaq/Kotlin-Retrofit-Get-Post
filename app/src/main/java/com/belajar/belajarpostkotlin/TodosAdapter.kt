package com.belajar.belajarpostkotlin

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodosAdapter(val todos:ArrayList<TodosModel.Data>):RecyclerView.Adapter<TodosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false))
    }

    override fun getItemCount(): Int {
       return todos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Data = todos[position]
        holder.todo.text = Data.todo
        holder.id.text = Data.id
    }



    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val id = view.findViewById<TextView>(R.id.id)
        val todo = view.findViewById<TextView>(R.id.todo)

    }

    fun setData(data:List<TodosModel.Data>) {
        todos.clear()
        todos.addAll(data)
        notifyDataSetChanged()
    }


}