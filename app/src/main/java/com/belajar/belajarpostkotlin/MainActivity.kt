package com.belajar.belajarpostkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api by lazy { RetrofitApi().apiEndPoint }
    lateinit var recyclerView: RecyclerView
    lateinit var todosAdapter: TodosAdapter
    lateinit var fab : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getListData()
        floatingAButton()
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    fun floatingAButton()
    {
        fab = findViewById(R.id.fab)
        fab.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,AddActivity::class.java))
        })
    }

    fun getListData()
    {
        recyclerView = findViewById(R.id.recycle)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        todosAdapter = TodosAdapter(arrayListOf())
        recyclerView.adapter = todosAdapter

    }

    fun getData()
    {
        api.getTodos().enqueue(object : Callback<TodosModel>{
            override fun onResponse(call: Call<TodosModel>, response: Response<TodosModel>) {
                val listData = response.body()!!.todos
                todosAdapter.setData(listData)
            }

            override fun onFailure(call: Call<TodosModel>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }
}