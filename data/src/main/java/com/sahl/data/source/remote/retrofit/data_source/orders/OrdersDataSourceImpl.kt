package com.sahl.data.source.remote.retrofit.orders.data_source.orders

import com.sahl.data.model.dto.OderDto
import com.sahl.data.source.remote.retrofit.orders.service.OrdersService
import javax.inject.Inject

class OrdersDataSourceImpl @Inject constructor(private val ordersService: OrdersService) :
    OrdersDataSource {
    override fun getListOfUserOrders(): List<OderDto> {
        return ordersService.getListOfUserOrders()
    }
}