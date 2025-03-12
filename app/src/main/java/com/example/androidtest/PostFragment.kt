package com.example.androidtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


class PostFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    //     private lateinit var postData: List<PostData>
//      private lateinit var post: List<Post>
    private val BASE_URL = "https://strengthen-numbers-stag.dev-imaginovation.net/"
    private lateinit var des: Post

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.postrecycler)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        des = Post(description = "Hello Here Description")
        postAdapter = PostAdapter(
            requireActivity(), listOf(des), false
        )
        getPostFeeds()

    }

    private fun getPostFeeds() {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(PostApiService::class.java)
            val retrodate = retrofit.getFeeds().awaitResponse()
            val likeData = retrofit.getLikes(217).awaitResponse()

            withContext(Dispatchers.Main) {
                Log.d("dhruv: ", "${retrodate.body().toString()}")
                Log.d("dhruv1: ", "${likeData.body().toString()}")
                recyclerView.adapter = postAdapter
            }
        }
    }

    //    private fun likepost(){
//        CoroutineScope(Dispatchers.IO).launch {
//            val retrofit= Retrofit. Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(PostApiService::class.java)
//            val retrodate= retrofit.getLikes(217).awaitResponse()
//
//
//            withContext(Dispatchers.Main){
//               Log.d("PostFragment","${retrodate.body().toString()}")
//                recyclerView.adapter= postAdapter
//            }
//        }
//    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PostFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}