package com.sahl.domain.repository

import com.sahl.domain.model.Order
import com.sahl.domain.model.enums.OrderStatus
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {

    val orderDetailsFlow: Flow<OrderStatus>

    fun getListOfUserOrders(): List<Order>

    suspend fun startOrderDetailsListener(orderId: Long)

}