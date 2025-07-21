package com.sahl.domain.model

import com.sahl.domain.model.enums.OrderStatus

data class Order(
    val id: Long,
    val costumerName: String,
    val restaurant: String,
    val status: OrderStatus
)
