package id.kotlin.basicmvp.config

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import id.kotlin.basicmvp.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object NetworkProvider {

  fun providesHttpAdapter(): Retrofit =
      Retrofit.Builder().apply {
        client(providesHttpClient())
        baseUrl(BuildConfig.URL)
        addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
      }.build()

  private fun providesHttpClient(): OkHttpClient =
      OkHttpClient.Builder().apply {
        retryOnConnectionFailure(true)
        addInterceptor(providesInterceptor())
        addInterceptor(providesHttpLoggingInterceptor())
      }.build()

  private fun providesInterceptor(): Interceptor =
      Interceptor { chain ->
        chain.proceed(
            chain.request().newBuilder().addHeader(
                "x-rapidapi-key",
                BuildConfig.KEY
            ).build()
        )
      }

  private fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
      HttpLoggingInterceptor().apply {
        level = when (BuildConfig.DEBUG) {
          true -> Level.BODY
          false -> Level.NONE
        }
      }
}