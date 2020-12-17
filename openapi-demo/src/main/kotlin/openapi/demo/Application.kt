package openapi.demo

import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.info.*

@OpenAPIDefinition(
    info = Info(
            title = "openapi-demo",
            version = "0.0"
    )
)
object Api {
    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
            .args(*args)
            .packages("openapi.demo")
            .start()
    }
}


