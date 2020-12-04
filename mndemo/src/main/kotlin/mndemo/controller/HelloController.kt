package mndemo.controller

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.inject.Singleton
import javax.validation.Valid


data class Applicant(
    val firstName: String,
    val lastName: String
)

data class Result(
    val someThing: String,
    val otherThing: String
)

@Singleton
@Controller("/hello")
open class HelloController {

    @Post(produces = [MediaType.APPLICATION_JSON])
    open fun acceptApplicant(@Body applicant: Applicant): Result {
        return Result(
            someThing = applicant.firstName,
            otherThing = applicant.lastName
        )
    }
}