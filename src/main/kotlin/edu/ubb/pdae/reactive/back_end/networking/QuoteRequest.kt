package edu.ubb.pdae.reactive.back_end.networking

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.ubb.pdae.reactive.back_end.model.Quote

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
class QuoteRequest(symbol: String, year: Int) {

    val URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.historicaldata%20where%20symbol%20%3D%20%22$symbol%22%20and%20startDate%20%3D%20%22$year-01-01%22%20and%20endDate%20%3D%20%22$year-12-31%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"

    fun loadData(): List<Quote>? {
        val (request, response, result) = URL.httpGet().responseObject(Deserializer())
        return result.component1()?.query?.results?.quote
    }

    //User Deserializer
    class Deserializer : ResponseDeserializable<RequestWrapper> {
        override fun deserialize(content: String): RequestWrapper? = gson.fromJson<RequestWrapper>(content, genericType<RequestWrapper>())
        inline fun <reified T> genericType() = object : TypeToken<T>() {}.type!!
    }

    companion object {
        // Static field to make sure only one instance exists
        val gson by lazy { Gson() }
    }
}