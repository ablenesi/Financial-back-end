package edu.ubb.pdae.reactive.back_end.data_import

import edu.ubb.pdae.reactive.back_end.model.Quote
import edu.ubb.pdae.reactive.back_end.networking.QuoteRequest
import edu.ubb.pdae.reactive.back_end.repository.CompanyRepository
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*


/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
object QuoteInput {

    fun load(): Map<String, MutableList<Quote>> {

        val quoteMap: MutableMap<String, MutableList<Quote>> = HashMap()
        for (company in CompanyRepository.instance.getAll()) {
            loadForYear(company.Symbol, Calendar.getInstance().get(Calendar.YEAR), quoteMap)
        }
        return quoteMap
    }

    fun loadForYear(Symbol: String, year: Int, quoteMap: MutableMap<String, MutableList<Quote>>) {
        println(Symbol + year)
        QuoteRequest(Symbol, year).loadData().subscribeOn(Schedulers.computation()).subscribe(object : SingleObserver<List<Quote>> {
            override fun onSuccess(quotesForYear: List<Quote>?) {
                if (quotesForYear != null) {
                    if (quoteMap[Symbol] == null) {
                        quoteMap[Symbol] = ArrayList()
                    }
                    quoteMap[Symbol]?.addAll(quotesForYear)
                }

                val previousYear = year - 1
                loadForYear(Symbol, previousYear, quoteMap)
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onError(e: Throwable?) {
            }
        })
    }
}