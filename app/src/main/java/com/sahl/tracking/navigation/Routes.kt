package com.sahl.tracking.navigation

import kotlinx.serialization.Serializable

@Serializable
object OrdersScreenRoute

@Serializable
data class OrderDetailsScreenRoute(
    val orderId: Long,
    val restaurant: String
)