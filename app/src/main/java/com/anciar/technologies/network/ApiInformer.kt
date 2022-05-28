package com.anciar.technologies.network

class ApiInformer<out T>(val status: ApiStatus,val data:T?, val message:String?,val code:Int?) {


    companion object {
        fun<T> success(data:T): ApiInformer<T> =
            ApiInformer(status = ApiStatus.SUCCESS,data = data, message = null,code=null)

        fun <T> error(data: T?, message: String,code: Int?=null): ApiInformer<T> =
            ApiInformer(status = ApiStatus.ERROR, data = data, message = message, code = code)

        fun <T> loading(data: T?): ApiInformer<T> =
            ApiInformer(status = ApiStatus.LOADING, data = data, message = null, code = null)

    }

}