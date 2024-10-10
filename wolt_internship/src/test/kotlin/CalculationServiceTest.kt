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
class CalculationServiceTest(
    @Autowired private var mockMvc: MockMvc
) {

    @BeforeEach
    fun setup() {
        mockMvc.dispatcherServlet.setDetectAllHandlerExceptionResolvers(true)
    }

    @Test
    fun successfulBigCartValueFeeCalculationTest() {
        val bigCartValueJson =
            "{\"cart_value\": 20000, \"delivery_distance\": 2235, \"number_of_items\": 4, \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(bigCartValueJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":0}"
                )
            )
    }

    @Test
    fun successfulSmallCartValueFeeCalculationTest() {
        val bigCartValueJson =
            "{\"cart_value\": 900, \"delivery_distance\": 2235, \"number_of_items\": 4, \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(bigCartValueJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":600}"
                )
            )
    }

    @Test
    fun successfulSmallDistanceFeeCalculationTest() {
        val bigCartValueJson =
            "{\"cart_value\": 790, \"delivery_distance\": 400, \"number_of_items\": 4, \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(bigCartValueJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":310}"
                )
            )
    }

    @Test
    fun successfulRoundDistanceFeeCalculationTest() {
        val bigCartValueJson =
            "{\"cart_value\": 790, \"delivery_distance\": 1500, \"number_of_items\": 4, \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(bigCartValueJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":510}"
                )
            )
    }

    @Test
    fun successfulBigNumberOfItemsFeeCalculationTest() {
        val bigCartValueJson =
            "{\"cart_value\": 790, \"delivery_distance\": 2235, \"number_of_items\": 10, \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(bigCartValueJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":1010}"
                )
            )
    }

    @Test
    fun successfulVeryBigNumberOfItemsFeeCalculationTest() {
        val bigCartValueJson =
            "{\"cart_value\": 790, \"delivery_distance\": 2235, \"number_of_items\": 14, \"time\": \"2024-01-15T12:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(bigCartValueJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":1330}"
                )
            )
    }

    @Test
    fun successfulFridayMidHoursFeeCalculationTest() {
        val bigCartValueJson =
            "{\"cart_value\": 790, \"delivery_distance\": 2235, \"number_of_items\": 10, \"time\": \"2024-01-19T15:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(bigCartValueJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":1212}"
                )
            )
    }

    @Test
    fun successfulTooBigFeeCalculationTest() {
        val bigCartValueJson =
            "{\"cart_value\": 790, \"delivery_distance\": 2235, \"number_of_items\": 14, \"time\": \"2024-01-19T15:00:00Z\"}"
        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(bigCartValueJson))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(
                content().string(
                    "{\"delivery_fee\":1500}"
                )
            )
    }
}