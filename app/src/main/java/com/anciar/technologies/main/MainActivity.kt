package com.anciar.technologies.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.anciar.technologies.databinding.ActivityMainBinding
import com.anciar.technologies.main.model.UserModel
import com.anciar.technologies.network.ApiStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private  val TAG = "MainActivity"
    private val viewModel by viewModels<MainActivityViewModel>()
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter :UserRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
//        initiateRecycler()
        initiateUserAdapter()
        observeViewModel()
    }

    private fun initiateUserAdapter() {
        adapter = UserRecyclerAdapter()
        binding.mainModuleRecycler.adapter = adapter
    }



    private fun observeViewModel() {
        viewModel.getSectionModelInfo()

        viewModel.userData.observe(this, Observer {response->
            when (response.status) {
                ApiStatus.LOADING -> {
                }

                ApiStatus.SUCCESS -> {
                    response.data?.let { userDataList ->
                        if (userDataList.isNotEmpty()) {
                            setDataToAdapter(userDataList)
                        }
                    }

                }

                ApiStatus.ERROR -> {
                    if(response.code == CUSTOMNETWORKLOSTCODE) {
                        Toast.makeText(this,"Netowk Lost",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })


        /* viewModel.sectionsModel.observe(this, Observer {data->
           data?.let {
               Log.d(TAG, "observeViewModel: ${it.size}")
               adapter.sectionInfo = it
           }
       })*/
    }

    private fun setDataToAdapter(userDataList: UserModel) {
        adapter.userData = userDataList
    }



/*
    private fun initiateRecycler() {
        adapter = SectionRecyclerAdapter()
        binding.mainModuleRecycler.adapter = adapter
        binding.mainModuleRecycler.addItemDecoration(
            SectionRecyclerItemDecoration(adapter, binding.root)
        )
        viewModel.getSectionModelInfo()
    }
*/
}