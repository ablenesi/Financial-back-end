package edu.ubb.pdae.reactive.back_end.data_import

import edu.ubb.pdae.reactive.back_end.model.Quote
import edu.ubb.pdae.reactive.back_end.networking.QuoteRequest
import edu.ubb.pdae.reactive.back_end.repository.CompanyRepository
import java.util.*


/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
object QuoteInput {

    fun load(): Map<String, List<Quote>> {

        val quoteMap: MutableMap<String, List<Quote>> = HashMap()
        for (company in CompanyRepository.instance.getAll()) {
            val quotes: MutableList<Quote> = ArrayList()
            var i = Calendar.getInstance().get(Calendar.YEAR)
            do {
                val quotesForYear: List<Quote>? = QuoteRequest(company.Symbol, i--).loadData()
                quotesForYear?.forEach(::println)
                if (quotesForYear != null) {
                    quotes.addAll(quotesForYear)
                }
            } while (quotesForYear != null)
            quoteMap[company.Symbol] = quotes
        }
        return quoteMap
    }

}