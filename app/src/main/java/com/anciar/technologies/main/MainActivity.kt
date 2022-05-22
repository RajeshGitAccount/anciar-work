package com.anciar.technologies.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.anciar.technologies.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private  val TAG = "MainActivity"
    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter :SectionRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        initiateRecycler()
        observeViewModel()
    }

    private fun initiateRecycler() {
        adapter = SectionRecyclerAdapter()
        binding.mainModuleRecycler.adapter = adapter
        binding.mainModuleRecycler.addItemDecoration(
            SectionRecyclerItemDecoration(adapter, binding.root)
        )
        viewModel.getSectionModelInfo()
    }


    private fun observeViewModel() {
        viewModel.sectionsModel.observe(this, Observer {data->
            data?.let {
                Log.d(TAG, "observeViewModel: ${it.size}")
                adapter.sectionInfo = it
            }
        })
    }
}