package com.sahl.tracking.di

import com.sahl.data.source.remote.data_source.orders.OrdersDataSource
import com.sahl.data.source.remote.data_source.orders.OrdersDataSourceImpl
import com.sahl.data.source.remote.service.orders.OrdersService
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

}