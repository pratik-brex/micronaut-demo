package openapi.demo.controllers

import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.Valid

@Introspected
data class Applicant(
    @field:Schema(description = "first name")
    val first_name: String?,
    @field:Schema(description = "last name")
    val last_name: String?,
    @field:Schema(description = "Primary address")
    val address: Address,
    @field:Schema(description = "Secondary address")
    val secondary_address: Address?,
    @field:Schema(description = "Other addresses")
    val other_addresses: Array<Address>
)

data class HelloRequest(
    val code: String?,
    @field:Schema(description = "Required information about the prospect.")
    @field:Valid
    val applicant: Applicant
)