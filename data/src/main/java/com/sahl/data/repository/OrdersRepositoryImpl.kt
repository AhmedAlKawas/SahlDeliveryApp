package com.sahl.data.repository

import com.sahl.data.mapper.toDomain
import com.sahl.data.source.remote.data_source.orders.OrdersDataSource
import com.sahl.domain.model.Order
import com.sahl.domain.repository.OrdersRepository
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(private val ordersDataSource: OrdersDataSource) :
    OrdersRepository {
    override fun getListOfUserOrders(): List<Order> {
        return ordersDataSource.getListOfUserOrders().map { orderDto ->
            orderDto.toDomain()
        }
    }
}