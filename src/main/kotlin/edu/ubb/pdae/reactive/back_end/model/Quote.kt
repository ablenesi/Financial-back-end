package edu.ubb.pdae.reactive.back_end.model

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
data class Quote(var symbol: String,
                 var date: Long,
                 var open: Double,
                 var close: Double,
                 var volume: Long)

