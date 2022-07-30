package com.belajar.belajarpostkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {

    private val api by lazy { RetrofitApi().apiEndPoint }
    lateinit var inputan : TextInputEditText
    lateinit var button : MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        logika()
    }

    fun logika()
    {
        inputan = findViewById(R.id.inputan)
        button = findViewById(R.id.submit)

        button.setOnClickListener(View.OnClickListener {
            val hasil:String = inputan.text.toString()
            if(hasil.isNotEmpty())
            {
                Log.e("HASIL: ",hasil)
                api.createTodos(hasil,id = 5, completed = false, userId = 2).enqueue(object :Callback<SubmitModel>{
                    override fun onFailure(call: Call<SubmitModel>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(
                        call: Call<SubmitModel>,
                        response: Response<SubmitModel>
                    ) {


                            val submit = response.body()
                            Toast.makeText(applicationContext,"Berhasil",Toast.LENGTH_LONG).show()
                            finish()

                    }
                })
            } else {
                Toast.makeText(applicationContext,"MOHON DIISI",Toast.LENGTH_LONG).show()
            }
        })
    }
}