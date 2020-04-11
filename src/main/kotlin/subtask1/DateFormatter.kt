package subtask1

import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val dayNum = day.toInt()
        val monthNum = month.toInt()
        val yearNum = year.toInt()
        var resultString: String
        try {
            val date = LocalDate.of(yearNum, monthNum, dayNum)
            resultString = day
            resultString += when (date.month){
                Month.JANUARY -> " января, "
                Month.FEBRUARY -> " февраля, "
                Month.MARCH -> " марта, "
                Month.APRIL -> " апреля, "
                Month.MAY -> " мая, "
                Month.JUNE -> " июня, "
                Month.JULY -> " июля, "
                Month.AUGUST -> " августа, "
                Month.SEPTEMBER -> " сентября, "
                Month.OCTOBER -> " октября, "
                Month.NOVEMBER -> " ноября, "
                Month.DECEMBER -> " декабря, "
            }
            resultString += when (date.dayOfWeek){
                DayOfWeek.MONDAY -> "понедельник"
                DayOfWeek.TUESDAY -> "вторник"
                DayOfWeek.WEDNESDAY -> "среда"
                DayOfWeek.THURSDAY -> "четверг"
                DayOfWeek.FRIDAY -> "пятница"
                DayOfWeek.SATURDAY -> "суббота"
                DayOfWeek.SUNDAY -> "воскресенье"
            }
        } catch (e: DateTimeException){return "Такого дня не существует"}
        return resultString
    }
}
