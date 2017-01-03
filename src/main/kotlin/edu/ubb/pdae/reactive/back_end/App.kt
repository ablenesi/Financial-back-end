package edu.ubb.pdae.reactive.back_end

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
@SpringBootApplication
open class App{

}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}