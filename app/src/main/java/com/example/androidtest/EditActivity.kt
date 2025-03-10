package com.example.androidtest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val fullname = findViewById<EditText>(R.id.fullname)
        val email = findViewById<EditText>(R.id.email)
        val dateofbirth = findViewById<EditText>(R.id.cal)

        val next = findViewById<Button>(R.id.next)

        next.setOnClickListener {
         postData()
        }


    }
    private fun postData(){
        val retrofit= Retrofit. Builder().addConverterFactory(GsonConverterFactory.create()).build().create(editApiService::class.java)
        val request= PostEditModel("Thursday","jenny@mailinator.com","Thursday.October")
        val retrodata= retrofit.getProfile(request)

        retrodata.enqueue(object : Callback<Response<List<EditModel>>>{
            override fun onResponse(
                call: Call<Response<List<EditModel>>>,
                response: Response<Response<List<EditModel>>>
            ) {
                val data= response.body() ?: return
                Toast.makeText(applicationContext,"Response Successfully done", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<Response<List<EditModel>>>, t: Throwable) {
                Toast.makeText(applicationContext,"Response is not done", Toast.LENGTH_SHORT).show()
            }

        })
    }
}