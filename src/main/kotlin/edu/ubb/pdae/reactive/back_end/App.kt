package edu.ubb.pdae.reactive.back_end

import edu.ubb.pdae.reactive.back_end.repository.QuotesRepository
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
@SpringBootApplication
open class App {
    var state: ApplicationState = ApplicationState.Loading()
}

fun main(args: Array<String>) {
    QuotesRepository.instance.getAll()
}