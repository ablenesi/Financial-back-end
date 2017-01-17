package edu.ubb.pdae.reactive.back_end.networking

import com.github.kittinunf.fuel.core.Deserializable
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.response
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.ubb.pdae.reactive.back_end.model.Quote
import io.reactivex.Single


/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
class QuoteRequest(symbol: String, year: Int) {

    val URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.historicaldata%20where%20symbol%20%3D%20%22$symbol%22%20and%20startDate%20%3D%20%22$year-01-01%22%20and%20endDate%20%3D%20%22$year-12-31%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys"

    fun loadData(): Single<List<Quote>> = URL.httpGet().rx_object(Deserializer())

    //User Deserializer
    class Deserializer : ResponseDeserializable<List<Quote>> {
        override fun deserialize(content: String): List<Quote>? = gson.fromJson<RequestWrapper>(content, genericType<RequestWrapper>())?.query?.results?.quote
        inline fun <reified T> genericType() = object : TypeToken<T>() {}.type!!
    }

    companion object {
        // Static field to make sure only one instance exists
        val gson by lazy { Gson() }
    }

    fun <T : Any> Request.rx_object(deserializable: Deserializable<T>) = rx_result(deserializable)

    private fun <T : Any> Request.rx_result(deserializable: Deserializable<T>): Single<T> =
            Single.create { subscriber ->
                response(deserializable) { request, response, result ->
                    when (result) {
                        is Result.Success -> {
                            subscriber.onSuccess(result.value)
                        }

                        is Result.Failure -> {
                            subscriber.onError(result.error)
                        }
                    }
                }
            }
}