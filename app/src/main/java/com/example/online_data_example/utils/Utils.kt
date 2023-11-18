package com.example.online_data_example.utils

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Utils {
    companion object {
        fun getRetrofitObject(): Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://api.unsplash.com")
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun createOkHttpClient() : OkHttpClient{
            return OkHttpClient.Builder()
                .addInterceptor(com.example.online_data_example.utils.HeaderIntercept())
                .build()
        }
    }
}

class HeaderIntercept : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val req = chain.request().newBuilder()
            .addHeader("Authorization", "Client-ID OudOmLNL8KvVl4FoCm8J0F7-UuF3I3cfKiBIAvwxxmA")
            .build();
        return chain.proceed(req)
    }

}