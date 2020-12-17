package openapi.demo.controllers

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.swagger.v3.oas.annotations.Operation
import javax.validation.Valid

@Controller("/v1/hello")
open class HelloController {
    @Post(
        consumes = [MediaType.APPLICATION_JSON],
        produces = [MediaType.APPLICATION_JSON]
    )
    @Operation(
        summary = "Summary of this endpoint",
        description = "Description of this endpoint"
    )
    open fun sayHello(@Body @Valid request: HelloRequest): HelloResponse {
        return HelloResponse("hello!")
    }

}