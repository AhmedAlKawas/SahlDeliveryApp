package com.sahl.data.source.remote.data_source.orders

import com.sahl.data.model.dto.OderDto

interface OrdersDataSource {

    fun getListOfUserOrders(): List<OderDto>

}