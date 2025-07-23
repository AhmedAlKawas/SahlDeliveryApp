package com.sahl.data.source.remote.web_socket.data_source

import com.sahl.domain.model.enums.OrderStatus
import kotlinx.coroutines.flow.Flow

interface OrderDetailsDataSource {

    val orderDetailsFlow: Flow<OrderStatus>

    suspend fun startOrderDetailsListener(orderId: Long)

}