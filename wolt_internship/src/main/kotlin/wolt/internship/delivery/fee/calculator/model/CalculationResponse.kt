package wolt.internship.delivery.fee.calculator.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CalculationResponse(
    @JsonProperty("delivery_fee")
    val deliveryFee: Int
)
