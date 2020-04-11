package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        when (blockB) {
            LocalDate :: class -> {
                var i=0
                while (blockA[i]?.javaClass != blockB.javaObjectType) i++
                var latestDate = blockA[i] as LocalDate
                while (i<blockA.lastIndex){
                    i++
                    if (blockA[i]?.javaClass == blockB.javaObjectType){
                        val tempDate: LocalDate = blockA[i] as LocalDate
                        if (tempDate.year>latestDate.year || (tempDate.year==latestDate.year && tempDate.dayOfYear>latestDate.dayOfYear)) latestDate=tempDate
                    }
                }
                return latestDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy").withLocale(Locale("ru")))
            }
            String :: class -> {
                var result=""
                for (i in blockA) if (i?.javaClass == blockB.javaObjectType) result+=i as String
                return result
            }
            else -> {
                var result=0
                for (i in blockA) if (i?.javaClass == blockB.javaObjectType) result+=i as Int
                return result
            }
        }
    }
}
