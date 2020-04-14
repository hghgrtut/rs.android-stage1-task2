package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val h = hour.toInt()
        var min = minute.toInt()
        var resultString = ""
        if (h in 0..12 && min in 0..60){
            val digitToText = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine")
            when {
                min==0 -> resultString = "${digitToText[h]} o' clock"
                min == 30 -> resultString = "half past ${digitToText[h]}"
                min == 15 -> resultString = "quarter past ${digitToText[h]}"
                min == 45 -> resultString = if (h!=12) "quarter to ${digitToText[h+1]}" else "quarter to one"
                min<30 -> {
                    resultString = "${digitToText[min]} minute"
                    if (min!=1) resultString+="s"
                    resultString += " past ${digitToText[h]}"}
                else -> {
                    min=60-min
                    resultString = "${digitToText[min]} minute"
                    if (min!=1) resultString+="s"
                    resultString += if (h!=12) " to ${digitToText[h+1]}" else " to one"
                }
            }
        }
        return resultString
    }
}
