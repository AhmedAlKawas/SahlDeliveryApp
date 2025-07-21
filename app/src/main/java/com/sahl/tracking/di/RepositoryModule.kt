package com.sahl.tracking.di

import com.sahl.data.repository.OrdersRepositoryImpl
import com.sahl.data.source.remote.data_source.orders.OrdersDataSource
import com.sahl.domain.repository.OrdersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideOrdersRepository(ordersDataSource: OrdersDataSource): OrdersRepository {
        return OrdersRepositoryImpl(ordersDataSource)
    }

}