package com.example.androidtest

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class EditActivity : AppCompatActivity() {
    private lateinit var sharedPreferences : SharedPreferences
    private val PREF_NAME  = "usershared_pref"
    private val Key_Latitude= "latitude"
    private val Key_Longitude= "longitude"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
       val viewpager= findViewById<ViewPager2>(R.id.viewpager)
       val previous= findViewById<Button>(R.id.previous)
       val next= findViewById<Button>(R.id.next)
        val teblayout= findViewById<TabLayout>(R.id.teblayout)

//        viewpager.adapter= ViewpagerAdapter(supportFragmentManager,this)
//
//        TabLayoutMediator(teblayout,viewpager){
//            tab, position->
//            if(position==2){
//                next.setText("Submit")
//            }
//        }.attach()
    }
}