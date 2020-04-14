package subtask4

class Pangram {

    fun getResult(inputString: String): String { return pairing(inputString, isPangram(inputString)) }

    private fun getFormattedResult(numberOfWords: Int, arr: Array<Pair<Int, String>>):String{
        var result=""
        if (numberOfWords>0) result+=arr[0].first.toString()+arr[0].second
        for (i in 1 until numberOfWords) result +=" "+arr[i].first.toString()+arr[i].second
        return result
    }

    private fun countWords(string: String): Int{
        var numberOfWords=0
        var last=' '
        for (i in string) {
            if (!i.isWhitespace() && last.isWhitespace())
                numberOfWords++
            last=i
        }
        return numberOfWords
    }

    private fun pairing(string: String, isPangram: Boolean): String{
        val numberOfWords=countWords(string)
        val arr :Array<Pair<Int,String>> = Array(numberOfWords) {Pair(0,"")}
        val consonants: Array<Char> = arrayOf('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z')
        val vowels: Array<Char> = arrayOf('A','E','I','O','U','Y')
        val target = if (isPangram) vowels else consonants
        var tempIndex=0
        for (i in 0 until numberOfWords){
            var numberOfTarget=0
            var tempString=""
            while(tempIndex<string.length && string[tempIndex].isWhitespace()) {tempIndex++}
            while(tempIndex<string.length && !string[tempIndex].isWhitespace()){
                tempString += if(target.contains(string[tempIndex].toUpperCase())) {
                    numberOfTarget++
                    string[tempIndex].toUpperCase()
                } else string[tempIndex]
                tempIndex++
            }
            arr[i]=Pair(numberOfTarget, tempString)
        }
        arr.sortBy { it.first }
        return getFormattedResult(numberOfWords, arr)
    }

    private fun isPangram(string: String): Boolean{
        var searched ='a'
        while (searched<='z'){
            if (!string.contains(searched) && !string.contains(searched.toUpperCase())) return false
            else searched++}
        return true
    }
}

