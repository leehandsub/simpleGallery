package com.example.simplegallery.network

import com.example.simplegallery.ApplicationClass

class RetrofitUtil {
    companion object {
        val photoApi: PhotoApi = ApplicationClass.retrofit.create(PhotoApi::class.java)
    }
}