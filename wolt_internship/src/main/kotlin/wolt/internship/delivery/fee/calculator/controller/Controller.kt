package wolt.internship.delivery.fee.calculator.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import wolt.internship.delivery.fee.calculator.model.CalculationRequest
import wolt.internship.delivery.fee.calculator.model.CalculationResponse
import wolt.internship.delivery.fee.calculator.service.CalculationService
import java.time.DateTimeException
import javax.validation.Valid


@RestController
@Validated
class Controller(
    private val calculationService: CalculationService
) {

    @PostMapping("/calculate")
    fun calculateFee(@Valid @RequestBody calculationRequest: CalculationRequest): CalculationResponse {
        return calculationService.calculateFee(
            calculationRequest.cartValue!!,
            calculationRequest.deliveryDistance!!,
            calculationRequest.numberOfItems!!,
            calculationRequest.time
        )
    }

    @ExceptionHandler(DateTimeException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleNoSuchElementFoundException(
        exception: DateTimeException
    ): ResponseEntity<String> {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Incorrect input time format: " + exception.message)
    }
}