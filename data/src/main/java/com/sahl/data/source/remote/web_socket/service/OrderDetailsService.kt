package com.sahl.data.source.remote.web_socket.service

import com.sahl.domain.model.enums.OrderStatus
import kotlinx.coroutines.flow.Flow

interface OrderDetailsService {

    val orderDetailsFlow: Flow<OrderStatus>

    suspend fun startOrderDetailsListener(orderId: Long)

}