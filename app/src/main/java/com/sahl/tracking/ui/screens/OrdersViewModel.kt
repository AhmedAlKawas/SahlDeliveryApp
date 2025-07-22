package com.sahl.tracking.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahl.domain.repository.OrdersRepository
import com.sahl.tracking.model.OrdersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(private val repository: OrdersRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<OrdersUiState>(OrdersUiState.Loading)
    val uiState: StateFlow<OrdersUiState> = _uiState.asStateFlow()

    init {
        getOrders()
    }

    private fun getOrders() {

        viewModelScope.launch {

            try {

                delay(2000)
                val orders = repository.getListOfUserOrders()
                _uiState.emit(OrdersUiState.Success(orders))

            } catch (e: Exception) {
                _uiState.emit(OrdersUiState.Error(e.message ?: "Something went wrong"))
            }

        }

    }

}