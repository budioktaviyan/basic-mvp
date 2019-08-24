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
        addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
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
                "65cc202591msh347c67fb6614d13p1774d5jsn76eb9a15458f"
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