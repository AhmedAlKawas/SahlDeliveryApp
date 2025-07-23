package com.sahl.data.repository

import com.sahl.data.mapper.toDomain
import com.sahl.data.source.remote.retrofit.orders.data_source.orders.OrdersDataSource
import com.sahl.data.source.remote.web_socket.data_source.OrderDetailsDataSource
import com.sahl.domain.model.Order
import com.sahl.domain.model.enums.OrderStatus
import com.sahl.domain.repository.OrdersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(
    private val ordersDataSource: OrdersDataSource,
    private val orderDetailsDataSource: OrderDetailsDataSource
) :
    OrdersRepository {
    override val orderDetailsFlow: Flow<OrderStatus>
        get() = orderDetailsDataSource.orderDetailsFlow

    override fun getListOfUserOrders(): List<Order> {
        return ordersDataSource.getListOfUserOrders().map { orderDto ->
            orderDto.toDomain()
        }
    }

    override suspend fun startOrderDetailsListener(orderId: Long) =
        orderDetailsDataSource.startOrderDetailsListener(orderId)
}