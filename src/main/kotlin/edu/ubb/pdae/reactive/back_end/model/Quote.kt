package edu.ubb.pdae.reactive.back_end.model

/**
 * Represents a days financial data for a {@link Company}.
 *
 * @autor Attila Blenesi ablenesi@gmail.com
 */
data class Quote(var Symbol: String,
                 var Date: String,
                 var Open: Double,
                 var Close: Double,
                 var High: Double,
                 var Low: Double,
                 var Volume: Long)
