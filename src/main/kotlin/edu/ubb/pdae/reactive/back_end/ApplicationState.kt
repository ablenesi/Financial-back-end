package edu.ubb.pdae.reactive.back_end

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
sealed class ApplicationState {
    class Loading : ApplicationState()
    class Available : ApplicationState()
}