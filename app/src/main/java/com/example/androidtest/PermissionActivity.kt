package com.example.androidtest

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PermissionActivity : AppCompatActivity() {
    private lateinit var sharedPreferences : SharedPreferences
    private val PREF_NAME  = "usershared_pref"
    private val Key_Latitude= "latitude"
    private val Key_Longitude= "longitude"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_permission)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        val bundle= intent.extras
        var lat= bundle?.getInt("latitude")
        var log= bundle?.getInt("longitude")
        val notallow= findViewById<Button>(R.id.donallow)
        val allow= findViewById<Button>(R.id.allowbtn)

        notallow.setOnClickListener {
            val intent= Intent(this,EditActivity::class.java)
            startActivity(intent)
        }
      allow.setOnClickListener {
          if(checkpermission()){
              Toast.makeText(applicationContext,"Permission already granted",Toast.LENGTH_SHORT).show()
              sharedPreferences= getSharedPreferences(PREF_NAME, MODE_PRIVATE)
              val editor= sharedPreferences.edit()
              editor.putInt(Key_Latitude,lat!!)
              editor.putInt(Key_Longitude,log!!)

              val intent= Intent(this@PermissionActivity, EditActivity::class.java)
              startActivity(intent)
              editor.apply()
          }
          else{
              requestPermission()
              sharedPreferences= getSharedPreferences(PREF_NAME, MODE_PRIVATE)
              val editor= sharedPreferences.edit()
              editor.putInt(Key_Latitude,lat!!)
              editor.putInt(Key_Longitude,log!!)
              editor.apply()
              val intent= Intent(this, EditActivity::class.java)
              startActivity(intent)
          }

      }
    }

    private fun checkpermission() : Boolean{
        return ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission(){
          ActivityCompat.requestPermissions(this, arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),1)
    }
}