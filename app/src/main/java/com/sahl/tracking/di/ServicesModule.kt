package com.sahl.tracking.di

import com.sahl.data.source.remote.service.orders.OrdersService
import com.sahl.data.source.remote.service.orders.OrdersServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Provides
    @Singleton
    fun provideOrdersServices(): OrdersService {
        return OrdersServiceImpl()
    }

}