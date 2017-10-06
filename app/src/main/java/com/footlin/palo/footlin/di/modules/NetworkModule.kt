package com.footlin.palo.footlin.di.modules

import com.footlin.palo.footlin.api.ApiService
import com.footlin.palo.footlin.constants.NetworkConstants
import com.footlin.palo.footlin.di.scopes.FootlinApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Named
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by user on 6/10/17.
 */

@Module
public class NetworkModule {
    @Provides
    @Named("BASE_URL")
    fun provideBaseUrlString(): String {
        return NetworkConstants.BASE_URL
    }

    @Provides
    @FootlinApplicationScope
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @FootlinApplicationScope
    @Provides
    fun provideRetrofit(gsonFactory: GsonConverterFactory, @Named("BASE_URL") baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gsonFactory)
                .build()
    }

    @Provides
    @FootlinApplicationScope
    fun provideProductsApi(retrofit: Retrofit): ApiService {
        return retrofit.create<ApiService>(ApiService::class.java)
    }
}