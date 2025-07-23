package com.sahl.tracking.ui.screens.order_details

sealed class DeliveryIntent {
    data class StartListening(val id: Long) : DeliveryIntent()
    data object StopListening : DeliveryIntent()
}