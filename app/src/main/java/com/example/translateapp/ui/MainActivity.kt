package com.example.translateapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.translateapp.data.TranslateItemResponseItem
import com.example.translateapp.databinding.ActivityMainBinding
import com.example.translateapp.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    private val mAdapter = TranslateAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSearch()


    }

    private fun getSearch() {
        binding.SearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    getDataApi(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }


    private fun setRecyclerView(it: List<TranslateItemResponseItem>) {
            binding.rvView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mAdapter
                mAdapter.setData(it)
            }
    }

    fun getDataApi(wordItem: String) {
        ApiConfig.getApiService().getSearchItem(wordItem).enqueue(object :
            Callback<List<TranslateItemResponseItem>> {
            override fun onResponse(
                call: Call<List<TranslateItemResponseItem>>,
                response: Response<List<TranslateItemResponseItem>>
            ) {
                response.body()?.let {
                    setRecyclerView(it)
                    binding.txtViewWord.text = it[0].word
                    binding.txtViewPhonetic.text = it[0].phonetic
                }
            }

            override fun onFailure(call: Call<List<TranslateItemResponseItem>>, t: Throwable) {
                Log.e("Tag", "onFailure:  $t")
            }
        })
    }
}