package com.technoidentity.roomdatabase.retrofit

import android.content.Context
import com.technoidentity.roomdatabase.Constants
import com.technoidentity.roomdatabase.MPIApi
import com.technoidentity.roomdatabase.Urls
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class MpiSource {

    private var restApi: MPIApi? = null
    var token = String()

    private fun init(){
        val interceptor =  HttpLoggingInterceptor()

        val headerAuthorizationInterceptor = object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                val request = chain.request()
                val builder:  Request.Builder  = request.newBuilder().header("Authorization",  String.format("bearer %s",token))
                val request1 = builder.build()
                return chain.proceed(request1)
            }
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder().addInterceptor(headerAuthorizationInterceptor).addInterceptor(interceptor).connectTimeout(60 , TimeUnit.SECONDS)
            .writeTimeout(60 , TimeUnit.SECONDS).readTimeout(30 , TimeUnit.SECONDS).build()

        val retrofit = Retrofit.Builder().baseUrl(Urls.BASE_URL_MPI)
            .client(client).addConverterFactory(GsonConverterFactory.create()).build()

        restApi = retrofit.create(MPIApi::class.java)
    }
    fun getRestApi(context: Context? = null): MPIApi? {
        context?.let {
            val sp = it.getSharedPreferences(Constants.PREFERENCE_NAME , Context.MODE_PRIVATE)
            token = sp.getString(Constants.TOKEN , token)!!
        }

        if (restApi!= null) {
            restApi = null

        }
        init()
        return restApi
    }
}