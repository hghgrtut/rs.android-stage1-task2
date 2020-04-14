package subtask1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val dayNum = day.toInt()
        val monthNum = month.toInt()
        val yearNum = year.toInt()
        val resultString: String
        try {resultString=LocalDate.of(yearNum, monthNum, dayNum).format(DateTimeFormatter.ofPattern("d MMMM, EEEE").withLocale(Locale("ru")))
        } catch (e: DateTimeException){return "Такого дня не существует"}
        return resultString
    }
}
