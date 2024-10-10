package wolt.internship.delivery.fee.calculator.service

import org.springframework.stereotype.Service
import wolt.internship.delivery.fee.calculator.model.CalculationResponse
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@Service
class CalculationService {

    fun calculateFee(
        cartValue: Int,
        deliveryDistance: Int,
        numberOfItems: Int,
        time: String
    ): CalculationResponse {
        if (cartValue >= 20000) {
            return CalculationResponse(0)
        }
        var surcharge = 0
        if (cartValue < 1000) {
            surcharge = 1000 - cartValue
        }
        if (deliveryDistance >= 1000) {
            surcharge += 200
            surcharge += if (deliveryDistance % 500 != 0) {
                ((deliveryDistance - 1000) / 500 + ((deliveryDistance - 1000) % 500 + 500) / 500) * 100
            } else {
                ((deliveryDistance - 1000) / 500) * 100
            }
        } else {
            surcharge += if (deliveryDistance % 500 != 0) {
                (deliveryDistance / 500 + (deliveryDistance % 500 + 500) / 500) * 100
            } else {
                (deliveryDistance / 500) * 100
            }
        }
        if (numberOfItems > 4) {
            surcharge += (numberOfItems - 4) * 50
            if (numberOfItems > 12) {
                surcharge += 120
            }
        }
        val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val dateTime = LocalDateTime.parse(time, pattern).atZone(ZoneId.of("UTC"))
        if (dateTime.dayOfWeek == DayOfWeek.FRIDAY && (dateTime.hour in 15..19)) {
            surcharge = (surcharge * 1.2).roundToInt()
        }
        return if (surcharge >= 1500) {
            CalculationResponse(1500)
        } else {
            CalculationResponse(surcharge)
        }
    }
}