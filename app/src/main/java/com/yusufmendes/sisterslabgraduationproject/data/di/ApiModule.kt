package com.yusufmendes.sisterslabgraduationproject.data.di

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yusufmendes.sisterslabgraduationproject.data.remote.ProductAPI
import com.yusufmendes.sisterslabgraduationproject.model.AppResponse
import com.yusufmendes.sisterslabgraduationproject.util.constants.Constants.BASE_URL
import com.yusufmendes.sisterslabgraduationproject.util.constants.Constants.STORE
import com.yusufmendes.sisterslabgraduationproject.util.retrofit.ResultCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    factory<Interceptor> {
        getInterceptor()
    }

    factory { getOkHttpClient(get()) }

    factory { provideRetrofit(get()) }

    factory { provideProductApi(get()) }
}

private fun getInterceptor(): Interceptor {
    // TODO default http interceptor
    return Interceptor {
        val request = it.request().newBuilder().addHeader("Content-Type", "application/json")
            .addHeader("store", STORE).build()

        val response = it.proceed(request)
        val responseBody: String = response.body?.string().orEmpty()
        val appResponse = GsonBuilder().create().fromJson(responseBody, AppResponse::class.java)
        if (appResponse.isSuccess) {
            it.proceed(request)
        } else {
            val contentJson = Gson().toJson(appResponse)
            Log.e("Interceptor", "ContentJson = $contentJson")
            Response.Builder().code(appResponse.status ?: -1).message(appResponse.message.orEmpty())
                .protocol(response.protocol).request(response.request)
                .body(responseBody.toResponseBody(response.body?.contentType())).build()
        }
    }
}

private fun getOkHttpClient(
    interceptor: Interceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(50, TimeUnit.SECONDS)
        .protocols(mutableListOf(Protocol.HTTP_1_1))
        .build()
}

private fun provideRetrofit(client: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(client)
        .build()

private fun provideProductApi(retrofit: Retrofit): ProductAPI {
    return retrofit.create(ProductAPI::class.java)
}