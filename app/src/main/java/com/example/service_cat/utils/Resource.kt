package com.example.service_cat.utils

data class Resource<out T>(val data : T, val status:Status, val message: String? ){

    companion object{
        fun <T> success(data: T) : Resource<T> = Resource<T>(data = data, status = Status.SUCCESS,
        message = null)
        fun <T> error(data: T, message: String?) : Resource<T> = Resource<T>( data = data, status = Status.ERROR,
        message = message)
        fun <T> loading(data: T): Resource<T> = Resource<T>( data = data, status = Status.LOADING,
            message = null)
    }
}
