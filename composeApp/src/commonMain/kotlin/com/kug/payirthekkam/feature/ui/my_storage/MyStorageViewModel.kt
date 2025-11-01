package com.kug.payirthekkam.feature.ui.my_storage

import Booking

//
//class MyStorageViewModel(private val repository: BookingRepository) :
//    BaseViewModel<MyStorageUiState, FeatureUiEvent, FeatureUiEffect>() {
//    override fun onEvent(event: FeatureUiEvent) {
//        when (event) {
//
//            else -> {}
//        }
//    }
//
//    override fun initialState() {
//        viewModelScope.launch {
//            MyStorageUiState.Success(
//                MyStorageData(
//                    bookingList = listOf(repository.getBookingById("", ""))
//                )
//            )
//        }
//    }
//}

data class MyStorageData(
    val tabItems: List<String> = listOf("Active", "Completed"),
    val bookingList: List<Booking>
)

//val mockBookings = listOf(
//    Booking(
//        id = "B001",
//        farmerId = "F123",
//        facilityId = "FAC45",
//        cropType = "Wheat",
//        quantity = 500,
//        status = "Confirmed",
//        startDate = "2025-11-01",
//        endDate = "2025-11-15"
//    ),
//    Booking(
//        id = "B002",
//        farmerId = "F456",
//        facilityId = "FAC67",
//        cropType = "Rice",
//        quantity = 300,
//        status = "Pending",
//        startDate = "2025-11-05",
//        endDate = null
//    )
//)
sealed class MyStorageUiState() {
    data object Loading : MyStorageUiState()
    data class Error(val message: String) : MyStorageUiState()
    data class Success(val data: MyStorageData) : MyStorageUiState()
    data object Idle : MyStorageUiState()
}

sealed class MyStorageUiEvent {

}

sealed class MyStorageUiEffect {

}