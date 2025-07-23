package com.sahl.tracking.ui.screens.order_details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahl.domain.model.enums.OrderStatus
import com.sahl.domain.use_cases.GetOrderDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderDetailsViewModel @Inject constructor(private val useCase: GetOrderDetailsUseCase) :
    ViewModel() {

    private val _uiState = MutableStateFlow(OrderStatus.Idle)
    val uiState: StateFlow<OrderStatus> = _uiState.asStateFlow()

    private var job: Job? = null

    fun onIntent(intent: DeliveryIntent) {
        when (intent) {
            is DeliveryIntent.StartListening -> {
                job?.cancel()

                job = viewModelScope.launch {
                    useCase(intent.id).collect { status ->
                        _uiState.value = status
                    }
                }
            }

            DeliveryIntent.StopListening -> {
                job?.cancel()
                job = null
            }
        }
    }

}