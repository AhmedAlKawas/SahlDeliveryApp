package com.sahl.tracking.di

import com.sahl.data.source.remote.retrofit.orders.data_source.orders.OrdersDataSource
import com.sahl.data.source.remote.retrofit.orders.data_source.orders.OrdersDataSourceImpl
import com.sahl.data.source.remote.retrofit.orders.service.OrdersService
import com.sahl.data.source.remote.web_socket.data_source.OrderDetailsDataSource
import com.sahl.data.source.remote.web_socket.data_source.OrderDetailsDataSourceImpl
import com.sahl.data.source.remote.web_socket.service.OrderDetailsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {

    @Provides
    @Singleton
    fun provideOrdersDataSource(ordersService: OrdersService): OrdersDataSource {
        return OrdersDataSourceImpl(ordersService)
    }

    @Provides
    @Singleton
    fun provideOrderDetailsDataSource(orderDetailsService: OrderDetailsService):
            OrderDetailsDataSource {
        return OrderDetailsDataSourceImpl(orderDetailsService)
    }

}