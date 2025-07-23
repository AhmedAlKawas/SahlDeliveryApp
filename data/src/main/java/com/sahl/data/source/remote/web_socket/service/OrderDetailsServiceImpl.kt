package com.sahl.data.source.remote.web_socket.service

import com.sahl.domain.model.enums.OrderStatus
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class OrderDetailsServiceImpl @Inject constructor() : OrderDetailsService {

    private val _orderDetailsFlow = MutableStateFlow(OrderStatus.Idle)

    override val orderDetailsFlow: Flow<OrderStatus>
        get() = _orderDetailsFlow

    override suspend fun startOrderDetailsListener(orderId: Long) {
        _orderDetailsFlow.emit(OrderStatus.Idle)
        delay(2000)
        _orderDetailsFlow.emit(OrderStatus.Preparing)
        delay(2000)
        _orderDetailsFlow.emit(OrderStatus.OutForDelivery)
        delay(2000)
        _orderDetailsFlow.emit(OrderStatus.Delivered)
    }
}