package com.anciar.technologies.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anciar.technologies.emailValidation
import com.anciar.technologies.login.model.LoginRequestModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(loginRespository: LoginRespository):ViewModel() {

    var loginRequest: MutableLiveData<LoginRequestModel> = MutableLiveData(LoginRequestModel())
    private val TAG = "LoginViewModel"
    var errorValidations: MutableLiveData<InValidErrors> = MutableLiveData()
    var succesResult: MutableLiveData<Boolean> = MutableLiveData()


    init {
//        loginRequest.value!!.email = "some@gmail.com"
//        loginRequest.value!!.pswd = "some"
    }

    fun onSubmitClick()
    {
        if (isInputValid(loginRequest.value?.email, password = loginRequest.value?.pswd)) {
            succesResult.value = true
        }
    }
    fun isInputValid(email: String?,password:String?): Boolean {
        arrayNotNulls(email,password)?.let {(mail,number)->
            when {
                mail.trim().emailValidation() -> {
                    errorValidations.value = InValidErrors.EMAILINCORRECT
                    return false
                }
                password?.trim().isNullOrEmpty() ->  {
                    errorValidations.value = InValidErrors.PASSWORDINCORRECT
                    return false
                }
                else ->  return true
            }
        }?: kotlin.run {
            errorValidations.value = InValidErrors.INCORRECTCREDENTIALS
            return false
        }
    }

    fun <T: Any> arrayNotNulls(vararg elements:T?): Array<T>? {
        if (null in elements) {
            return null
        }
        return elements as Array<T>
    }


}

enum class InValidErrors {
    PASSWORDINCORRECT, EMAILINCORRECT,INCORRECTCREDENTIALS
}