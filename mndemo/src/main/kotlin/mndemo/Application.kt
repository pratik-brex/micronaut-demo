package mndemo

import io.micronaut.runtime.Micronaut

object Application {

	@JvmStatic
	fun main(args: Array<String>) {
		Micronaut.build()
			.args(*args)
			.packages("mndemo")
			.start()
	}
}

