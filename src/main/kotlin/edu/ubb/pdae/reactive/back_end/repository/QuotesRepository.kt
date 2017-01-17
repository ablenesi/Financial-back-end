package edu.ubb.pdae.reactive.back_end.repository

import edu.ubb.pdae.reactive.back_end.data_import.QuoteInput
import edu.ubb.pdae.reactive.back_end.model.Quote

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
class QuotesRepository private constructor() : Repository<Pair<String, List<Quote>>> {

    companion object {
        val instance by lazy { QuotesRepository() }
    }

    private val quotes: Map<String, MutableList<Quote>> = QuoteInput.load()

    override fun getAll(): List<Pair<String, List<Quote>>> = quotes.toList()

    override fun get(id: String): Pair<String, List<Quote>>? = if (quotes[id] == null) null else Pair(id, quotes[id]!!)

}