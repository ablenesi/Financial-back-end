package edu.ubb.pdae.reactive.back_end

import edu.ubb.pdae.reactive.back_end.repository.QuotesRepository
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
@SpringBootApplication
open class App {

    var state: ApplicationState

    init {
        state = ApplicationState.Loading()
    }

}

fun main(args: Array<String>) {
    println("34567890")
    println(QuotesRepository.instance.getAll())
    println("34567890")
}