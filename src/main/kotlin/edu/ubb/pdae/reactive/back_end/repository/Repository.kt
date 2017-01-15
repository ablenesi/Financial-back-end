package edu.ubb.pdae.reactive.back_end.repository

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
interface Repository<out TYPE> {

    fun getAll(): List<TYPE>
    fun get(id: String): TYPE?
}