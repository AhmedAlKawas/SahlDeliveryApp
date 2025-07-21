package com.sahl.data.source.remote.service.orders

import com.sahl.data.model.dto.OderDto
import javax.inject.Inject

class OrdersServiceImpl @Inject constructor() : OrdersService {
    override fun getListOfUserOrders(): List<OderDto> {
        return listOf(
            OderDto(
                id = 1,
                customerName = "Ahmed Al-Kawas",
                restaurant = "Primos",
                status = "Delivered"
            ),
            OderDto(
                id = 2,
                customerName = "Ahmed Ehab",
                restaurant = "Pizza Hut",
                status = "Preparing"
            ),
            OderDto(
                id = 3,
                customerName = "Mohammed Al-Kawas",
                restaurant = "McDonald's",
                status = "Out for delivery"
            ),
            OderDto(
                id = 4,
                customerName = "Ahmed Al-Kawas",
                restaurant = "KFC",
                status = "Cancelled"
            ),
        )
    }
}