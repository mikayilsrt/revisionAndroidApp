package com.app.revisionandroidapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.revisionandroidapp.R
import com.app.revisionandroidapp.adapters.MovieAdapter
import com.app.revisionandroidapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), CustomModalFragment.ExampleDialogListener {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var adapter: MovieAdapter

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.initialRecyclerView()

        this.viewModel.getMovies().observe(this, Observer {
            this.adapter.list = it
            this.adapter.notifyDataSetChanged()
        })

        binding.buttonDialog.setOnClickListener { this.openDialog() }
    }

    private fun openDialog() {
        val customModalFragment: CustomModalFragment = CustomModalFragment()

        customModalFragment.show(supportFragmentManager, "custom dialog")
    }

    private fun initialRecyclerView() {
        val recyclerView = binding.movieList
        this.adapter = MovieAdapter()

        val gridLayoutManager: GridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        gridLayoutManager.spanSizeLookup = object: GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if ((position % 3) == 0) 2 else 1
            }
        }

        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = this.adapter
    }

    override fun applyTexts(string1: String, string2: String) {
        binding.mainText.text = "${string1} - ${string2}"
    }
}