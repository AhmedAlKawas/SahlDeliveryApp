package com.sahl.data.source.remote.web_socket.data_source

import com.sahl.data.source.remote.web_socket.service.OrderDetailsService
import com.sahl.domain.model.enums.OrderStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderDetailsDataSourceImpl @Inject constructor(
    private val orderDetailsService: OrderDetailsService
) :
    OrderDetailsDataSource {
    override val orderDetailsFlow: Flow<OrderStatus>
        get() = orderDetailsService.orderDetailsFlow

    override suspend fun startOrderDetailsListener(orderId: Long) =
        orderDetailsService.startOrderDetailsListener(orderId)

}