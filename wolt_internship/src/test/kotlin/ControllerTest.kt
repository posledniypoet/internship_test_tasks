import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import wolt.internship.delivery.fee.calculator.Application


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = [Application::class])
@AutoConfigureMockMvc
class ControllerTest(
    @Autowired private var mockMvc: MockMvc
) {
    private val correctRequestJson =
        "{\"cart_value\": 790, \"delivery_distance\": 2235, \"number_of_items\": 4, \"time\": \"2024-01-15T12:00:00Z\"}"

    @BeforeEach
    fun setup() {
        mockMvc.dispatcherServlet.setDetectAllHandlerExceptionResolvers(true)
    }

    @Test
    fun successfulFeeCalculationTest() {
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(correctRequestJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":710}"
                )
            )
    }

    @Test
    fun badRequestWithoutCartValueFieldTest() {
        val incorrectJson = "{\"delivery_distance\": 2235, \"number_of_items\": 4, \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(incorrectJson))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun badRequestWithoutNumberOfItemsFieldTest() {
        val incorrectJson =
            "{\"cart_value\": 790, \"delivery_distance\": 2235, \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(incorrectJson))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun badRequestWithoutDeliveryDistanceFieldTest() {
        val incorrectJson =
            "{\"cart_value\": 790, \"number_of_items\": 4 , \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(incorrectJson))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun badRequestWithoutTimeFieldTest() {
        val incorrectJson =
            "{\"cart_value\": 790, \"number_of_items\": 4 , \"delivery_distance\": 2235}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(incorrectJson))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun badRequestWithEmptyTimeFieldTest() {
        val incorrectJson =
            "{\"cart_value\": 790, \"number_of_items\": 4 , \"delivery_distance\": 2235, \"time\": \"\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(incorrectJson))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun badRequestWithTimeFieldIncorrectFormatTest() {
        val incorrectJson =
            "{\"cart_value\": 790, \"delivery_distance\": 2235, \"number_of_items\": 4, \"time\": \"2024-01-15T39:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(incorrectJson))
            .andExpect(status().isInternalServerError)
    }
}