package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when (blockB) {
            LocalDate :: class -> blockA.filterIsInstance<LocalDate>().max()!!.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            String :: class -> blockA.filterIsInstance<String>().joinToString("")
            else -> blockA.filterIsInstance<Int>().sum()
        }
    }
}
