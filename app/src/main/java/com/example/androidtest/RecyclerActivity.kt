package com.example.androidtest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RecyclerActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var postTabLayout: TabLayout
    private lateinit var postViewPagerAdapter: PostViewPager
    val tabname = listOf("posts", "dashbord")
    val tabicon = listOf(R.drawable.house, R.drawable.share)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        viewPager = findViewById(R.id.postviewpager)
        postTabLayout = findViewById(R.id.postteblayout)
        postViewPagerAdapter = PostViewPager(supportFragmentManager, this.lifecycle)
        viewPager.adapter = postViewPagerAdapter

        TabLayoutMediator(postTabLayout, viewPager) { tab, position ->
            tab.text = tabname[position]
//            tab.icon= tabicon[position]
        }.attach()
    }
}