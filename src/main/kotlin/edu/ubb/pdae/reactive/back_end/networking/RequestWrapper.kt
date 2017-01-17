package edu.ubb.pdae.reactive.back_end.networking

import edu.ubb.pdae.reactive.back_end.model.Quote

/**
 * Helper class for automatic deserialization.
 *
 * @autor Attila Blenesi ablenesi@gmail.com
 */

class RequestWrapper {
    var query: Query? = null
}

class Query {
    var results: Result? = null
}

class Result {
    var quote: List<Quote>? = null
}