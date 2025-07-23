package com.sahl.domain.model.enums

enum class OrderStatus {
    Idle,
    Preparing,
    OutForDelivery,
    Delivered,
    Cancelled,
    Unknown
}

fun statusToString(orderStatus: OrderStatus): String {

    return when (orderStatus) {
        OrderStatus.Idle -> "Idle"
        OrderStatus.Preparing -> "Preparing"
        OrderStatus.OutForDelivery -> "Out for delivery"
        OrderStatus.Delivered -> "Delivered"
        OrderStatus.Cancelled -> "Cancelled"
        OrderStatus.Unknown -> "Unknown"
    }

}