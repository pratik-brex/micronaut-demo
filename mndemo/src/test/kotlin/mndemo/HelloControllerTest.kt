package mndemo

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class HelloControllerTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun testItWorks() {
        Assertions.assertEquals(client.toBlocking().retrieve(
            HttpRequest.POST(
                "/hello",
                """
                    {"first_name": "Jill", "last_name": "Doe"}
                """.trimIndent()
            )
        ), """{"some_thing":"Jill","other_thing":"Doe"}""")
    }

}