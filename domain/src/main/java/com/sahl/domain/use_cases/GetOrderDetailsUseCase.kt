package com.sahl.domain.use_cases

import com.sahl.domain.model.enums.OrderStatus
import com.sahl.domain.repository.OrdersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetOrderDetailsUseCase @Inject constructor(private val repository: OrdersRepository) {

    operator fun invoke(orderId: Long): Flow<OrderStatus> = channelFlow {

        launch {
            repository.startOrderDetailsListener(orderId)
        }

        repository.orderDetailsFlow.collect { send(it) }

    }

}