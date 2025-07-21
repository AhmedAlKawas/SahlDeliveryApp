package com.sahl.domain.repository

import com.sahl.domain.model.Order

interface OrdersRepository {

    fun getListOfUserOrders(): List<Order>

}