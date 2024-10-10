package wolt.internship.delivery.fee.calculator.model

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CalculationRequest(

    @JsonProperty("cart_value")
    @field:NotNull(message = "Cart value must not be null")
    val cartValue: Int?,

    @JsonProperty("delivery_distance")
    @field:NotNull(message = "Delivery distance must not be null")
    val deliveryDistance: Int?,

    @JsonProperty("number_of_items")
    @field:NotNull(message = "Number of items must not be null")
    val numberOfItems: Int?,

    @JsonProperty("time")
    @field:NotBlank(message = "Time must not be blank")
    val time: String
)