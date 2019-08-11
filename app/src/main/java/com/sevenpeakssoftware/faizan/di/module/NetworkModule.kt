package com.sevenpeakssoftware.faizan.di.module

import com.sevenpeakssoftware.faizan.network.AutoApi
import com.sevenpeakssoftware.faizan.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Module which provides all required dependencies about network
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {
    /**
     * Provides the CarManufacturer service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the CarManufacturer service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideCarApi(retrofit: Retrofit): AutoApi {
        return retrofit.create(AutoApi::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}