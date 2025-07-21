package com.sahl.data.mapper

import com.sahl.data.model.dto.OderDto
import com.sahl.domain.model.Order
import com.sahl.domain.model.enums.OrderStatus

fun OderDto.toDomain(): Order {
    return Order(
        id = id,
        costumerName = customerName,
        restaurant = restaurant,
        status = getOrderStatus(status)
    )
}

fun getOrderStatus(status: String): OrderStatus {
    return when (status) {
        "Delivered" -> OrderStatus.Delivered
        "Cancelled" -> OrderStatus.Cancelled
        "Out for delivery" -> OrderStatus.OutForDelivery
        "Preparing" -> OrderStatus.Preparing
        else -> OrderStatus.Unknown
    }
}
