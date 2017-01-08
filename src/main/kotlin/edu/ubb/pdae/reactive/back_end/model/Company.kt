package edu.ubb.pdae.reactive.back_end.model

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
data class Company(var Symbol: String,
                   var Name: String,
                   var LastSale: String,
                   var MarketCap: String,
                   var IPOyear: Long,
                   var Sector: String,
                   var industry: String,
                   var Summary: String,
                   var Quote: String)