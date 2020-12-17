package openapi.demo.controllers

import io.micronaut.core.annotation.Introspected
import io.swagger.v3.oas.annotations.media.Schema

@Introspected
data class Address(
    @field:Schema(description = "Address line 1, no PO Box.")
    val line1: String?,
    @field:Schema(description = "Address line 2 (e.g., apartment, suite, unit, or building).")
    val line2: String?,
    @field:Schema(description = "City, district, suburb, town, or village.")
    val city: String?,
    @field:Schema(description = "For US-addressed the 2-letter State abbreviation. For international-addresses the County, Providence, or Region.")
    val state: String?,
    @field:Schema(description = "Two-letter country code (ISO 3166-1 alpha-2).")
    val country: String?,
    @field:Schema(description = "ZIP or postal code.")
    val postal_code: String?,
    @field:Schema(description = "Phone number.") // should we require E614 format?
    val phone_number: String?
)
