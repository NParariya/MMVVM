package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.ViewModel.ViewModel
import com.example.mvvm.ViewModel.ViewModelFactory
import com.example.mvvm.databinding.ListBinding

class Listactivity : AppCompatActivity() {


    private lateinit var binding: ListBinding

    private val viewModel : ViewModel by lazy {
        ViewModelProvider(this, ViewModelFactory())
            .get(ViewModel::class.java)

    }

    private lateinit var jokesAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Doges List"

        viewModel.refresh()
        setupUI()

        binding.refresh.setOnRefreshListener {
            fun onRefresh() {
                Toast.makeText(getApplicationContext(), "Works!", Toast.LENGTH_LONG).show()}
        }
    }

    private fun setupUI() {
        jokesAdapter = MyAdapter(ArrayList())

        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.adapter = jokesAdapter

        viewModel.mylist.observe(this, {joke ->
            joke?.let{myList ->
                binding.recycle.visibility = View.VISIBLE
                binding.progressbar.visibility = View.GONE
                jokesAdapter.updatelist(myList)
            }
        })
    }
}


