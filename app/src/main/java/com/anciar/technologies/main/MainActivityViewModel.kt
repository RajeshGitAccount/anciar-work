package com.anciar.technologies.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anciar.technologies.main.model.SectionsModel
import com.anciar.technologies.main.model.UserModel
import com.anciar.technologies.network.ApiInformer
import com.anciar.technologies.network.NetworkNotConnectedException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

val CUSTOMNETWORKLOSTCODE = 800
@HiltViewModel
class MainActivityViewModel
@Inject constructor (val mainRepository: MainRepository): ViewModel() {

    var userData: MutableLiveData<ApiInformer<UserModel>> = MutableLiveData()

    fun getSectionModelInfo() {
        viewModelScope.launch {
            try {
                userData.postValue(ApiInformer.success(mainRepository.getRecyclerData())
                )
            } catch (exception: NetworkNotConnectedException) {
                userData.postValue(
                    ApiInformer.error(data = null, message = exception.message ?: "Error Occurred!",code = CUSTOMNETWORKLOSTCODE)
                )
            } catch (exception: IOException) {
                userData.postValue(
                    ApiInformer.error(data = null, message = exception.message ?: "Error Occurred!")
                )
            } catch (exception: HttpException) {
                userData.postValue(
                    ApiInformer.error(data = null, message = exception.message ?: "Error Occurred!")
                )
            }
        }
    }

}