package edu.ubb.pdae.reactive.back_end.data_import

import edu.ubb.pdae.reactive.back_end.model.Company
import java.io.File
import java.nio.charset.Charset

/**
 * @autor Attila Blenesi ablenesi@gmail.com
 */
object CompanyInput {

    val FILE_URL: String = "/Users/battila/University/PDAE/Project/src/main/resources/companylist.csv"

    // Position of value in data source
    private val SYMBOL: Int = 0
    private val NAME: Int = 1
    private val LAST_SALE: Int = 2
    private val MARKET_CAP: Int = 3
    private val IPO_YEAR: Int = 4
    private val SECTOR: Int = 5
    private val INDUSTRY: Int = 6

    /**
     * Opens the given file from the url then parses the Company data.
     */
    fun read(url: String): List<Company> = File(url)
            .readLines(Charset.defaultCharset())
            .map { companyFactory(it) }

    /**
     * Helper function for parsing the following data into {@link Company} class.
     *
     * Source example:
     * "WYNN","Wynn Resorts, Limited","87.46","$8.9B","2002","Consumer Services","Hotels/Resorts",
     *
     * @autor Attila Blenesi ablenesi@gmail.com
     */
    private fun companyFactory(dataRow: String): Company {
        val data: List<String> = dataRow.split("\",\"")
        println(data)

        // Handle optional IPO year
        var ipoYear: Long? = null
        try {
            ipoYear = data[IPO_YEAR].toLong()
        } catch (e: NumberFormatException) {
            println("IPO year not available for: " + data[SYMBOL])
        }

        return Company(data[SYMBOL].removePrefix("\""), data[NAME], data[LAST_SALE], data[MARKET_CAP],
                ipoYear, data[SECTOR], data[INDUSTRY])
    }
}


