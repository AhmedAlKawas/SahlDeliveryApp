package com.sahl.data.source.remote.retrofit.orders.service

import com.sahl.data.model.dto.OderDto

// This class is supposed to hold the orders GET and POST requests
interface OrdersService {

//    This is the retrofit call but we are going to mock up this api call
//    @Get("orders")
//    suspend fun getListOfUserOrders(): Response

    fun getListOfUserOrders(): List<OderDto>

}