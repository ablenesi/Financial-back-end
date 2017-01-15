package edu.ubb.pdae.reactive.back_end.model

/**
 * Represents a Company from the stock market.
 *
 * @autor Attila Blenesi ablenesi@gmail.com
 */
data class Company(var Symbol: String,
                   var Name: String,
                   var LastSale: String,
                   var MarketCap: String,
                   var IPOYear: Long?,
                   var Sector: String,
                   var industry: String)