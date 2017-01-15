package edu.ubb.pdae.reactive.back_end.repository

import edu.ubb.pdae.reactive.back_end.data_import.CompanyInput
import edu.ubb.pdae.reactive.back_end.model.Company

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
class CompanyRepository : Repository<Company> {

    companion object {
        val instance by lazy { CompanyRepository() }
    }

    private val companies: List<Company> = CompanyInput.read(CompanyInput.FILE_URL)

    override fun get(id: String): Company = companies.filter { it.Symbol == id }.first()

    override fun getAll(): List<Company> = companies
}
