package com.anciar.technologies.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anciar.technologies.main.model.SectionsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel
@Inject constructor (val mainRepository: MainRepository): ViewModel() {

    var sectionsModel: MutableLiveData<ArrayList<SectionsModel>> = MutableLiveData()

    fun getSectionModelInfo() {
        viewModelScope.launch {
            sectionsModel.value = mainRepository.getRecyclerData()
        }
    }

}