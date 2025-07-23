package com.sahl.tracking.di

import com.sahl.domain.repository.OrdersRepository
import com.sahl.domain.use_cases.GetOrderDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    @Singleton
    fun provideGetOrderDetailsUseCase(repository: OrdersRepository): GetOrderDetailsUseCase {
        return GetOrderDetailsUseCase(repository)
    }

}