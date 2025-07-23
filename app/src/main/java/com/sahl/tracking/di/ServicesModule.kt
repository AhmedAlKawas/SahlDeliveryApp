package com.sahl.tracking.di

import com.sahl.data.source.remote.retrofit.orders.service.OrdersService
import com.sahl.data.source.remote.retrofit.orders.service.OrdersServiceImpl
import com.sahl.data.source.remote.web_socket.service.OrderDetailsService
import com.sahl.data.source.remote.web_socket.service.OrderDetailsServiceImpl
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

    @Provides
    @Singleton
    fun provideOrderDetailsServices(): OrderDetailsService {
        return OrderDetailsServiceImpl()
    }

}